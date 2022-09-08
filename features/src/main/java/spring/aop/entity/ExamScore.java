package spring.aop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.aop.entity.Exam;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ExamScore implements Exam {

	private int kor;
	private int eng;
	private int math;
	private int com;
	
	@Override
	public int total() {
		int result = kor + eng + math + com;
		
		if(kor > 100) {
			throw new IllegalArgumentException("유효하지 않은 점수 입니다.");
		}
		return result;
	}
	
	@Override
	public float avg() {
		float result = total() / 4.0f;
		return result;
	}

	@Override
	public String toString() {
		return "ExamScore [kor=" + kor + ", eng=" + eng + ", math=" + math + ", com=" + com + "]";
	}
	
	
}
