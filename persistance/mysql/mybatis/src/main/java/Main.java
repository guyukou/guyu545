import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        System.out.println(mapper.selectById(10001));
        sqlSession.close();
         sqlSession = sqlSessionFactory.openSession(true);
          mapper = sqlSession.getMapper(BlogMapper.class);
          mapper.updateSalary();
        sqlSession.close();

        sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(BlogMapper.class);
        System.out.println(mapper.selectById(10001));

//        sqlSession.commit();
//        mapper.updateTitle(10001, "garry1");
//        sqlSession.commit();
    }
}
