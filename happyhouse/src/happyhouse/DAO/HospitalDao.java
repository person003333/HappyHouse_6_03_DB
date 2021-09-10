package happyhouse.DAO;

import java.util.*;
import happyhouse.DTO.*;

public interface HospitalDao {
	List<HospitalDto> searchAll(String guguncode);
}
