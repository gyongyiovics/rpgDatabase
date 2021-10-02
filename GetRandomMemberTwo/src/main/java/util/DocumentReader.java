package util;

import config.ConfigReader;
import exceptions.MyException;
import model.Member;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DocumentReader {
    public static List<Member> loadMembers () {
        List<Member> members = new ArrayList<>();
        try {
            Stream<String> stream = Files.lines(Paths.get(ConfigReader.getMembersPath()));
            stream.forEach(line -> {
                if (!line.contains(ConfigReader.getCommentPrefix())) {
                    if (!line.contains(ConfigReader.getPresentedPrefix())) {
                        members.add(new Member(line));
                    } else {
                        members.add(new Member(line, true));
                    }
                } else {
                    // TODO check commentPrefix position
                    // TODO if prefix position != 0
                    // TODO substring
                }
            });
            if (members.isEmpty()) {
                System.out.println("There is no member in the input file");
                //throw new MyException();
            }
            System.out.println(members.size() + " member loaded!");
        } catch(NoSuchFileException e) {
            System.out.println("Rossz elérési út lett megadva!");
            System.out.println(e.getMessage());
            //throw new MyException();
        } catch (
                IOException e) {
            System.out.println("Unknown error");
            e.printStackTrace();
            //throw new MyException();
        }
        return members;
    }
}
