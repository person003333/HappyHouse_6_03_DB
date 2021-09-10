package happyhouse.DAO;

import java.util.*;
import happyhouse.DTO.*;

public interface CommDao {
	List<CommDto> searchAll(String guguncode);
}
