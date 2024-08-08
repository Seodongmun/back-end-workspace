package mapper;
import org.apache.ibatis.annotations.Mapper;

import com.kh.ajax.model.vo.Member;


// Mapper 쓰려면 xml 추가해야함
@Mapper
public interface MemberMapper {
	
	Member idCheck(String id);

}
