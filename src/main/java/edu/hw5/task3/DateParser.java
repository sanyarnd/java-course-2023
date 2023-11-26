package edu.hw5.task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class DateParser {
    public Optional<LocalDate> parseDate(String incomingDate) {
        Handler tomorrowHandler = new TomorrowHandler();
        Handler todayHandler = new TodayHandler();
        Handler yesterdayHandler = new YesterdayHandler();
        Handler daysAgoHandler = new DaysAgoHandler();
        Handler defaultHandler = new DefaultHandler();

        tomorrowHandler.setNext(todayHandler);
        todayHandler.setNext(yesterdayHandler);
        yesterdayHandler.setNext(daysAgoHandler);
        daysAgoHandler.setNext(defaultHandler);

        return tomorrowHandler.handle(incomingDate);
    }

    interface Handler {
        void setNext(Handler handler);

        Optional<LocalDate> handle(String incomingDate);
    }

    class TomorrowHandler implements Handler {
        private Handler next;

        @Override
        public void setNext(Handler handler) {
            this.next = handler;
        }

        @Override
        public Optional<LocalDate> handle(String incomingDate) {
            if (incomingDate.equals("tomorrow")) {
                return Optional.of(LocalDate.now().plusDays(1));
            }
            return next.handle(incomingDate);
        }
    }

    class TodayHandler implements Handler {
        private Handler next;

        @Override
        public void setNext(Handler handler) {
            this.next = handler;
        }

        @Override
        public Optional<LocalDate> handle(String incomingDate) {
            if (incomingDate.equals("today")) {
                return Optional.of(LocalDate.now());
            }
            return next.handle(incomingDate);
        }
    }

    class YesterdayHandler implements Handler {
        private Handler next;

        @Override
        public void setNext(Handler handler) {
            this.next = handler;
        }

        @Override
        public Optional<LocalDate> handle(String incomingDate) {
            if (incomingDate.equals("yesterday")) {
                return Optional.of(LocalDate.now().minusDays(1));
            }
            return next.handle(incomingDate);
        }
    }

    class DaysAgoHandler implements Handler {
        private Handler next;

        @Override
        public void setNext(Handler handler) {
            this.next = handler;
        }

        @Override
        public Optional<LocalDate> handle(String incomingDate) {
            if (incomingDate.endsWith(" days ago") || incomingDate.endsWith(" day ago")) {
                int daysAgo = Integer.parseInt(incomingDate.split(" ")[0]);
                return Optional.of(LocalDate.now().minusDays(daysAgo));
            }
            return next.handle(incomingDate);
        }
    }

    class DefaultHandler implements Handler {
        @Override
        public void setNext(Handler handler) {
            // This is the last handler in the chain
        }

        @Override
        public Optional<LocalDate> handle(String incomingDate) {
            try {
                return Optional.of(
                    LocalDate.parse(
                        incomingDate,
                        DateTimeFormatter.ofPattern("[M/d/yyyy][yyyy-MM-dd][M/d/yy][yyyy-MM-d]")
                    )
                );
            } catch (Exception e) {
                return Optional.empty();
            }
        }
    }
}
