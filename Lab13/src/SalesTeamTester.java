public class SalesTeamTester {
	public static void main(String[] args){
		int [] employeeSales = {
								3286, 2249, 3728, 2866, 2217, 4235, 735, 3898,
								2723, 4147, 3001, 2986, 438, 3375, 639, 2543,
								2273, 2814, 2588, 1303, 3965, 3754, 3072, 2231,
								1746, 2444, 2273, 3318, 2485, 4184, 3677, 4232,
								3764, 1705, 4586, 4846, 3855, 4240, 4487, 5110, 4167,
								3849, 3444, 4154, 3123, 4596, 3396, 2770, 2182,
								2908, 4266, 3551, 3555, 2643, 3375};
	
	SalesTeam team = new SalesTeam(employeeSales);
	team.printSalaryDistribution(200, 100, 9);
	}
}

