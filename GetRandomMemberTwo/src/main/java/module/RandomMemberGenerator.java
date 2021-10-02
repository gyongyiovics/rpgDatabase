package module;

import exceptions.MyException;
import model.Member;
import util.DocumentReader;
import util.MyRandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class RandomMemberGenerator {
    private static List<Member> members = new ArrayList<>();
    public static void run() throws MyException {
        try {
            members = DocumentReader.loadMembers();
            System.out.println(
                    members.get(MyRandomGenerator.getRandom(members.size()))
                            .getName()
            );
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
