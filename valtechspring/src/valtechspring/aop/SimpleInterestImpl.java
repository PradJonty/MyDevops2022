package valtechspring.aop;

public class SimpleInterestImpl implements SimpleInterest {



	   private Arithmetic arithmetic;
	    public SimpleInterestImpl(){}
	    public SimpleInterestImpl(Arithmetic arithmetic){
	        this.arithmetic=arithmetic;
	    }
	    public void setArithmetic(Arithmetic arithmetic){
	        this.arithmetic=arithmetic;
	    }
	    
	    @Override
	    public int computeSimpleInterest(int principle, int time, int rateOfInterest){
	        return arithmetic.div(arithmetic.mul(principle,time,rateOfInterest), 100);
	    }
	}
