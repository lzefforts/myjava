package org.study.drools;

import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatelessKnowledgeSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ArnoldLee on 17/4/11.
 */
public class RuleUtil {

    protected static Logger LOGGER = LoggerFactory.getLogger(RuleUtil.class);

    private static String rulePathUrl = "rule/";

    public static Object executeRule(String ruleName,Object object) throws Exception {

        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

        kbuilder.add( ResourceFactory.newClassPathResource(rulePathUrl+ruleName,
                RuleUtil.class ),
                ResourceType.DRL);

        if ( kbuilder.hasErrors() ) {
            LOGGER.error("规则文件读取异常");
        }

        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages( kbuilder.getKnowledgePackages() );

        StatelessKnowledgeSession ksession = kbase.newStatelessKnowledgeSession();
        ksession.execute( object );
        return object;
    }


}
