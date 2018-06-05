package personRest.math;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.System.out;

@RestController
public class MathController {

    @Autowired
    private MathService mathService;

    @RequestMapping("/math/add")
    public long add(@RequestParam long a,  @RequestParam long b)
    {
        return mathService.add(a,b);
    }

    @RequestMapping("/math/multiple")
    public long multiple(@RequestParam long a,  @RequestParam long b)
    {
        return mathService.multiple(a,b);
    }

    @RequestMapping("/math/quadratic")
    public String quadratic(@RequestParam long a,  @RequestParam long b, @RequestParam long c)
    {
        return mathService.quadraticEquation(a,b,c);
    }

}
