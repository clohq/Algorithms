/*

Find the units of water stagnated in between buildings

*/

public class BuildingWaterMatrix {
	public static void main(String[] args) {
		int[] buildings = {3,1,3,1,3,1,3,1};
		System.out.println(findWaterInBuildings(buildings));
	}

	public static int findWaterInBuildings(int[] buildings) {
		int maxBuilding = 0;

		for(int building : buildings) {
			if (building > maxBuilding) maxBuilding = building;
		}

		int totalWater = 0;

		for(int height = 1; height <= maxBuilding; height++) {
			boolean buildingOn = false;
			int tempWater = 0;
			for(int building = 0; building < buildings.length; building++) {
				if (buildings[building] >= height) {
					if(buildingOn)
					{
						totalWater += tempWater;
						tempWater = 0;
					}
					else
						buildingOn = true;
				} else {
					if(buildingOn)
						tempWater ++;
				}
			}
			System.out.println(totalWater);
		}
		return totalWater;
	}
}