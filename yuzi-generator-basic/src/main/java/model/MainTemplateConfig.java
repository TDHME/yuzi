package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MainTemplateConfig {

    private String  author = "yupi";

    private String outputText = "输出结果";

    private boolean loop;


}
