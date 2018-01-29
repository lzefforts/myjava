package org.study.lombok;





import lombok.Data;

import java.io.Serializable;

/**
 * Created by ArnoldLee on 17/8/31.
 */
@Data
public class ShowVo implements Serializable {

    private static final long serialVersionUID = -6962247049910071217L;

    private String name;

    private String sex;
}
