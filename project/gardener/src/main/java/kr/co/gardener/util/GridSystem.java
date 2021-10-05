package kr.co.gardener.util;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class GridSystem {
	public HashMap<String, Object> getGrid() {
		HashMap<String, Object> grid = new HashMap<String, Object>();

		Field[] list = this.getClass().getDeclaredFields();

		for (int a = 0; a < list.length; a++) {

			try {
				Field field = list[a];
				
				field.setAccessible(true);
				if (field.getType().toString().indexOf("Date") > 0) {
					DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					grid.put("C" + a, format.format(field.get(this)));
				} else {
					grid.put("C" + a, field.get(this));
				}

			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return grid;
	}
}
