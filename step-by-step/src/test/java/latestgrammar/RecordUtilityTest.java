package latestgrammar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class RecordUtilityTest {

    @Test
    void 한국말_언더바() {
        TargetClass target = TargetClass.of("성훈", 10);

        RecordUtility recordUtility = RecordUtility.getRecordUtility(target);
        String key = recordUtility.key();
        int value = recordUtility.value();

        assertThat(key).isEqualTo("성훈");
        assertThat(value).isEqualTo(10);
    }
}
