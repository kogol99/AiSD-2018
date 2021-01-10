package Lista7;

class ElementToStringExec implements IExecutor<Element, String>{
    StringBuffer sb=new StringBuffer();
    @Override
    public void execute(Element elem) {
        sb.append(elem+"; ");}
    @Override
    public String getResult(){
        sb.delete(sb.length()-2, sb.length());
        return sb.toString();
    }
}
