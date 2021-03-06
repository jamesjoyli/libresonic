package org.libresonic.player.dao;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.libresonic.player.util.LibresonicHomeRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

@ContextConfiguration(locations = {
        "/applicationContext-service.xml",
        "/applicationContext-cache.xml",
        "/applicationContext-testdb.xml",
        "/applicationContext-mockSonos.xml"})
public class DaoTestCaseBean2 {
    @ClassRule
    public static final SpringClassRule classRule = new SpringClassRule() {
        LibresonicHomeRule libresonicRule = new LibresonicHomeRule();
        @Override
        public Statement apply(Statement base, Description description) {
            Statement newBase = libresonicRule.apply(base, description);
            return super.apply(newBase, description);
        }
    };

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

    @Autowired
    GenericDaoHelper genericDaoHelper;


    JdbcTemplate getJdbcTemplate() {
        return genericDaoHelper.getJdbcTemplate();
    }
}
