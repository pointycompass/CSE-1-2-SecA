
import java.util.List;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import static java.lang.System.*;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom");
        String result = Joiner.on(",").join(names);
        out.println(result);
        Iterable<String> items = Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("GeeksforGeeks ,is,, the, best, website, to, prepare, for, interviews,");
        items.forEach(e -> out.println(e));
    }
}
