package com.github.affandes.kuliah.pm;

import java.util.Stack;
import java.util.Scanner;

public class Main {
    final Stack<String> backpage;
    final Stack<String> forwardpage;
    private String currentUrl;

    public Main() {
        backpage = new Stack<>();
        forwardpage = new Stack<>();
        currentUrl = null;
    }

    public void open(String url) {
        if (currentUrl != null) {
            backpage.push(currentUrl);
        }
        currentUrl = url;
        forwardpage.clear();
        System.out.println("Opened : " + currentUrl);
    }

    public void goBack() {
        if (backpage.isEmpty()) {
            System.out.println("Tidak ada halaman.");
        } else {
            forwardpage.push(currentUrl);
            currentUrl = backpage.pop();
            System.out.println("Mau pergi ke : " + currentUrl);
        }
    }


    public void goForward() {
        if (forwardpage.isEmpty()) {
            System.out.println("Tidak ada halaman baru");
        } else {
            backpage.push(currentUrl);
            currentUrl = forwardpage.pop();
            System.out.println("Mau Pergi ke: " + currentUrl);
        }
    }

    public void currentPage() {
        if (currentUrl == null) {
            System.out.println("Tidak ada halaman terbuka");
        } else {
            System.out.println("Sekarang berada di : " + currentUrl);
        }
    }

    public static void main(String[] args) {
        Main browser = new Main();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Commands: open, back, forward, current, exit");

        while (true) {
            System.out.print("Enter command: ");
            command = scanner.nextLine();

            if (command.startsWith("open")) {
                String url = command.substring(5);
                browser.open(url);
            } else if (command.equals("back")) {
                browser.goBack();
            } else if (command.equals("forward")) {
                browser.goForward();
            } else if (command.equals("current")) {
                browser.currentPage();
            } else if (command.equals("exit")) {
                System.out.println("Exiting browser...");
                break;
            } else {
                System.out.println("Invalid Command");
            }
        }

        scanner.close();
    }
}
