package com.uptake.common;

/**
 * @author rmurug3
 *
 */
public class Constants {

	public static final int TIMEOUT = 30;

	public enum Browser {

		IE("ie"), CHROME("chrome");
		String name;

		public String getName() {
			return name;
		}

		private Browser(String name) {
			this.name = name;
		}

	}

	public enum Action {
		CLICKABLE, VISIBILITY;

	}
}
