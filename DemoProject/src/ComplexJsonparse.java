import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonparse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js = new JsonPath(payload.CoursePrice());
		// print no of courses returned by API
		int count=js.getInt("courses.size()");
		System.out.println(count);
		
		// Print purchase amount
		int totalAmount=js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
		
		//Print title of first course
		String titleFirstCourse =js.getString("courses[0].title");
		System.out.println(titleFirstCourse);
		
		//print all courses and prices
		for(int i=0;i<count;i++)
		{
			String courseTitles=js.get("courses["+i+"].title");
			System.out.println(js.get("courses["+i+"].price").toString());
			System.out.println(courseTitles);
		}
		
		//print no of copies sold by RPA
		System.out.println("no of copies sold by RPA");
		for(int i=0;i<count;i++)
		{
			String courseTitles = js.get("courses["+i+"].title");
			if(courseTitles.equalsIgnoreCase("RPA"))
			{
				int copies =js.getInt("courses["+i+"].copies");
				System.out.println(copies);
				break;
			}
		}
		
		
	}

}
