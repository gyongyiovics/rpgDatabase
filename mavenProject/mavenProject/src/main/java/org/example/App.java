package org.example;

import org.example.fetchData.Fetch;
import java.io.IOException;

public class App 
{
    public static void main(String args[]) throws IOException {
        Fetch fetch = new Fetch();

        fetch.printSimply();
        fetch.printWithMethod();
    }
}
