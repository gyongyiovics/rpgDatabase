package util;

import config.ConfigReader;
import exceptions.MyException;
import model.Member;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class DocumentReaderTest {
    @Test
    public void loadMembersTest() throws MyException {
        MockedStatic<ConfigReader> configMock = Mockito.mockStatic(ConfigReader.class);
        configMock.when(ConfigReader::getMembersPath).thenReturn("src/test/resources/test_members.txt");
        configMock.when(ConfigReader::getCommentPrefix).thenCallRealMethod();
        configMock.when(ConfigReader::getPresentedPrefix).thenCallRealMethod();     // partial mock

        List<Member> expectedResult = Arrays.asList(
                new Member("Sanyika"),
                new Member("Nagy Pistike")
        );
        List<Member> actualResult = DocumentReader.loadMembers();
        Assert.assertTrue(compareMemberLists(expectedResult, actualResult));
    }

    /**
     *         1.2 Check prefix
     *             - create new test txt  (valid line, commented line, presented line)
     *             - comment
     *             - presented
     */

    private boolean compareMemberLists(List<Member> expected, List<Member> actual) {
        if (expected.size() != actual.size())
            return false;
        for (int i = 0; i < expected.size(); i++) {
            if (!(expected.get(i).getName().equals(actual.get(i).getName()) &&
                    expected.get(i).isPresented() == actual.get(i).isPresented()))
                return false;
        }

        return true;
    }
}
