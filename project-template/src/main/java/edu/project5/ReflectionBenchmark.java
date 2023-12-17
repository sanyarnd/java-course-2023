package edu.project5;

import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;
import static java.lang.invoke.MethodType.methodType;

@State(Scope.Thread)
public class ReflectionBenchmark {
    private Method directAccessMethod;
    private Method reflectionMethod;
    private MethodHandles.Lookup lookup;
    private CallSite callSite;
    private Student student;

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
            .include(ReflectionBenchmark.class.getSimpleName())
            .shouldFailOnError(true)
            .shouldDoGC(true)
            .mode(Mode.AverageTime)
            .timeUnit(TimeUnit.NANOSECONDS)
            .forks(1)
            .warmupForks(1)
            .warmupIterations(1)
            .warmupTime(TimeValue.seconds(5))
            .measurementIterations(1)
            .measurementTime(TimeValue.minutes(2))
            .build();

        new Runner(options).run();
    }

    @Setup
    public void setup() throws Exception {
        student = new Student("Big", "Fat");
        directAccessMethod = Student.class.getDeclaredMethod("name");
        reflectionMethod = Student.class.getDeclaredMethod("name");
        lookup = MethodHandles.lookup();
        MethodType methodType = methodType(String.class);
        MethodHandle methodHandle = lookup.findVirtual(Student.class, "name", methodType);
        callSite = LambdaMetafactory.metafactory(lookup, "get",
            methodType(Supplier.class, Student.class),
            methodType(Object.class),
            methodHandle,
            methodType
        );
    }

    @Benchmark
    public void directAccess(Blackhole bh) {
        String name = student.name();
        bh.consume(name);
    }

    @Benchmark
    public void reflection(Blackhole bh) throws InvocationTargetException, IllegalAccessException {
        String name = (String) reflectionMethod.invoke(student);
        bh.consume(name);
    }

    @Benchmark
    public void methodHandles(Blackhole bh) throws Throwable {
        String name = (String) lookup.unreflect(directAccessMethod).invoke(student);
        bh.consume(name);
    }

    @Benchmark
    public void lambdaMetafactory(Blackhole bh) throws Throwable {
        Supplier<String> supplier = (Supplier<String>) callSite.getTarget().invokeExact(student);
        String name = supplier.get();
        bh.consume(name);
    }
}
