package Client;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import junit.framework.Assert;

import com.epam.mentoring.hibernate.entity.Address;
import com.epam.mentoring.hibernate.entity.Employee;
import com.epam.mentoring.hibernate.entity.Employee.EmployeeStatus;
import com.epam.mentoring.hibernate.entity.PersonalInfo;
import com.epam.mentoring.hibernate.entity.Project;
import com.epam.mentoring.hibernate.entity.Unit;
import com.epam.mentoring.hibernate.service.EmployeeService;
import com.epam.mentoring.hibernate.service.ProjectService;
import com.epam.mentoring.hibernate.service.UnitService;

public class Client {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		try {
			final EmployeeService employeeService = getEmployeeService();
			final UnitService unitService = getUnitService();
			final ProjectService projectService = getProjectService();

			final Employee employee1 = getEmployee1();
			employeeService.create(employee1);
			List<Employee> employees = employeeService.findAll();
			Assert.assertNotNull(employees);

			final Unit unit1 = getUnit1();
			unitService.create(unit1);
			final List<Unit> units = unitService.findAll();
			Assert.assertNotNull(units);

			final Project project1 = getProject();
			projectService.create(project1);
			final List<Project> projects = projectService.findAll();
			Assert.assertNotNull(projects);

			employeeService.assignEmployeeToProject(employees.get(0).getId(),
					projects.get(0).getId());

			employees = employeeService.findAll();

			Assert.assertNotNull(((List) employees.get(0).getProjects()).get(0));

		} catch (final NamingException e) {
			e.getMessage();
		} catch (final IOException e) {
			e.getMessage();
		}
	}

	public static Employee getEmployee1() {
		final Address address = new Address();
		address.setCity("Grodno");
		address.setStreet("Gorkogo");

		final Employee employee = new Employee();
		employee.setAddress(address);
		employee.setName("Andrei");
		employee.setStatus(EmployeeStatus.FULL_TIME);

		final PersonalInfo personalInfo = new PersonalInfo();
		personalInfo.setCharacteristics("Char");

		employee.setPersonalInfo(personalInfo);

		return employee;
	}

	public static Unit getUnit1() {
		final Unit unit = new Unit();
		unit.setName("E-commerce");
		return unit;
	}

	public static Project getProject() {
		final Project project = new Project();
		project.setName("Ooo-yeah");
		return project;
	}

	private static Context getContext() throws NamingException {

		final Hashtable<String, Object> p = new Hashtable<String, Object>();
		p.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.jboss.naming.remote.client.InitialContextFactory");
		p.put("jboss.naming.client.ejb.context", true);
		p.put(Context.PROVIDER_URL, "remote://127.0.0.1:4447/");
		p.put(InitialContext.SECURITY_PRINCIPAL, "andrei");
		p.put(InitialContext.SECURITY_CREDENTIALS, "pass");
		p.put("jboss.naming.client.connect.options.org.xnio.Options.SASL_POLICY_NOPLAINTEXT",
				"false");

		final Context context = new InitialContext(p);
		return context;
	}

	public static EmployeeService getEmployeeService() throws NamingException,
			IOException {
		return (EmployeeService) getContext()
				.lookup("07-hibernate-0.0.1-SNAPSHOT/EmployeeServiceImpl!com.epam.mentoring.hibernate.service.EmployeeService");
	}

	public static UnitService getUnitService() throws NamingException,
			IOException {
		return (UnitService) getContext()
				.lookup("07-hibernate-0.0.1-SNAPSHOT/UnitServiceImpl!com.epam.mentoring.hibernate.service.UnitService");
	}

	public static ProjectService getProjectService() throws NamingException,
			IOException {
		return (ProjectService) getContext()
				.lookup("07-hibernate-0.0.1-SNAPSHOT/ProjectServiceImpl!com.epam.mentoring.hibernate.service.ProjectService");
	}

}
