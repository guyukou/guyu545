import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogMapper {
    List<Employees> selectBlog(long id);

    Employees selectById(long id);

    void updateTitle(@Param("id") long id, @Param("title")String title);

    void updateSalary();
}
