package com.company;

/*

1613 Big Ben clock
1. Understand what the program does.
2. Implement the logic of the printTime method so that every second is given a time starting from the one set in the constructor
Example:
To London now 23:59:58!
To London now 23:59:59!
It's midnight in London!
In London it is now 0: 0: 1!

Requirements:
1. The printTime method should take about a second.
2. The printTime method should increase (increment) the number of seconds stored in the seconds variable.
3. Seconds, after incrementing time, cannot be more than 59. The number of minutes should increase.
4. Minutes after the time increment cannot be more than 59. The number of hours should increase.
5. Hours, after incrementing time, cannot be more than 23.

 */

import java.util.ArrayList;
import java.util.List;


public class Solution {
    public static volatile boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock("Лондон", 23, 59, 57);
        Thread.sleep(4000);
        isStopped = true;
        Thread.sleep(1000);
    }

    public static class Clock extends Thread {
        private String cityName;
        private int hours;
        private int minutes;
        private int seconds;

        public Clock(String cityName, int hours, int minutes, int seconds) {
            this.cityName = cityName;
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
            start();
        }

        public void run() {
            try {
                while (!isStopped) {
                    printTime();
                }
            } catch (InterruptedException e) {
            }
        }

        private void printTime() throws InterruptedException {
            //add your code here - добавь код тут
            if (hours == 0 && minutes == 0 && seconds == 0) {
                System.out.println(String.format("В г. %s сейчас полночь!", cityName));
            } else {
                System.out.println(String.format("В г. %s сейчас %d:%d:%d!", cityName, hours, minutes, seconds));
            }

            seconds += 1;
            if (seconds > 59) {
                seconds = 0;
                minutes += 1;
            }
            if (minutes > 59) {
                minutes = 0;
                hours += 1;
            }
            if (hours > 23) {
                hours = 0;
            }

            Thread.sleep(1000);
        }
    }
}



