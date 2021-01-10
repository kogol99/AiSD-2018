package Lista8;

class ElementToStringExec implements IExecutor<Integer, String>{
    StringBuffer sb=new StringBuffer();
    @Override
    public void execute(int elem) {
        sb.append(elem+"; ");}
    @Override
    public String getResult(){
        sb.delete(sb.length()-2, sb.length());
        return sb.toString();
    }
}
