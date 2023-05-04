public  class Company  {
    static Integer compId = 1;
    static String name = "X-minds";
    static String place = "tvm";
    public String getName(){
        return name;
    }
    public String getPlace(){
        return place;
    }

    Company(){
        name="xminds";
        place="tvm";
    }
    Company(Company a){
        name=a.getName();
        place=a.getPlace();
    }
    Company(String a,String b){
        name=a;
        place=b;
    }
    public static Company createObject(){
        Company company = null;
        company.name = "X-minds";
        company.place = "tvm";
        return company;
    }
    public static Company company=new Company();
}
