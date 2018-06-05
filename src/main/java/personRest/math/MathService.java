package personRest.math;

import org.springframework.stereotype.Service;

@Service
public class MathService {

    public long add(long a, long b)
    {
        return a+b;
    }

    public long multiple(long number, long multiplier)
    {
        return number*multiplier;
    }

    public String quadraticEquation(long a, long b, long c)
    {
        return a+"x^2 + "+b+"x + "+c;
    }



}

