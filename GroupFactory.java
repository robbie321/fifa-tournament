public class GroupFactory{
  public GroupFactory(){
    
  }
  public Group CreateGroup(int gn, Players[] names){
    Group group = new Group(gn,names);
    return group;

  }
}