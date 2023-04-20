package hkAiRpaProject.contoller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PythonConteoller {
	@Autowired
	PythonInterpreter intPre;
	@RequestMapping("python")
	public String python(
			@RequestParam(value="a") Integer aaaa,
			@RequestParam(value="b") Integer bbbb,
			Model model) {
		intPre.execfile("src/main/resources/templates/thymeleaf/python/pythonTest.py");
		PyFunction pyFunction = intPre.get("testFunc", PyFunction.class);
		PyObject pyobj = pyFunction.__call__(new PyInteger(aaaa),new PyInteger(bbbb) );
		model.addAttribute("pyobj", pyobj.toString());
		return "thymeleaf/python/python";
	}
	@GetMapping("agePython")
	public String agePython() {
		return "thymeleaf/python/python";
	}
	@PostMapping("agePython")
	public String agePython(
			@RequestParam(value="location") String location) {
		
		return "thymeleaf/python/python";
	}
	public String commandFunc(String fileName) {
		System.out.println(fileName);
		String result = "";
		try {
			Process process  = Runtime.getRuntime().exec("powershell -Command python " + fileName);
			//new BufferedReader( new InputStreamReader(process.getInputStream()));
			BufferedReader reader = new BufferedReader(
			        new InputStreamReader(process.getInputStream()));
			String line = null;
			StringBuffer sb = new StringBuffer();
			while ((line = reader.readLine()) != null) {
			    sb.append(line);
			    sb.append("\n");
			}
			result = sb.toString();
			System.out.println(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}









