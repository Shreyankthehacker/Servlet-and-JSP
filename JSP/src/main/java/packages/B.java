package packages;

public abstract class B extends org.apache.jasper.runtime.HttpJspBase{
public static int x = 10;
public static String s =  "when i want to extend a class sinside the page directive tag make sure that i also extend the vendor class which i use as server"
+" bcz when it compiles it creates a pagedirective class whcih already extends vendor class and now if u extend one more then it becomes "
+" multiinheritence which is not allowed in java so extend vendor class";
}
