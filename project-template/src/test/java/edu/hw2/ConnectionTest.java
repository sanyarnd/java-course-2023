package edu.hw2;

import edu.hw2.ConnectionTask.Connection.*;
import edu.hw2.ConnectionTask.ConnectionException;
import edu.hw2.ConnectionTask.Managers.*;
import edu.hw2.ConnectionTask.PopularCommandExecutor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConnectionTest {

    // Всегда проблемное соединение
    @Test
    public void testFautlyConnectionManager(){
        ConnectionManager manager = new FaultyConnectionManager();
        for(int i =0; i < 100; i += 1){
            Connection con = manager.getConnection();
            Assertions.assertEquals(FaultyConnection.class ,con.getClass());
        }
    }

    @Test
    public void testDefaultConnectionManager(){
        ConnectionManager manager = new DefaultConnectionManager();
        int countStable = 0;
        int countFautly = 0;
        for(int i =0; i < 100; i += 1){
            try (Connection con = manager.getConnection()) {
                if (StableConnection.class.equals(con.getClass())) {
                    countStable += 1;
                } else if (FaultyConnection.class.equals(con.getClass())) {
                    countFautly += 1;
                } else Assertions.fail();
            } catch (Exception e) {
                Assertions.fail();
            }
        }
        Assertions.assertFalse(countFautly == 0 || countStable == 0);
    }
    @Test
    public void testFautlyConnection() {
        int c = 0;
        for (int i = 0; i < 100; i += 1) {
            try(Connection con = new FaultyConnection()){
                con.execute("asd");
            }catch (ConnectionException e){
                c += 1;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (c == 0)
            Assertions.fail();
    }

    @Test
    public void testPopularExecutor(){
        PopularCommandExecutor executor = new PopularCommandExecutor(new FaultyConnectionManager(), 1);
        int flag1 = 0;
        for(int i =0; i < 100; i +=1){
            try {
                executor.tryExecute("asd");
            } catch (ConnectionException con){
                flag1 += 1;
                break;
            }
        }
        Assertions.assertNotEquals(0, flag1);
        Assertions.assertNotEquals(100, flag1);


        executor = new PopularCommandExecutor(new DefaultConnectionManager(), 1);
        flag1 = 0;
        for(int i =0; i < 100; i +=1){
            try {
                executor.tryExecute("asd");
            } catch (ConnectionException con){
                flag1 += 1;
                break;
            }
        }
        Assertions.assertNotEquals(0, flag1);
        Assertions.assertNotEquals(100, flag1);
    }

}
