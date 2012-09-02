
class EnvironmentVariablesService {
	private Map env;
	
	Map getEnvironmentVariables() {
		if (env == null) {
			env = System.getenv()
		}
		return env
	}
}
