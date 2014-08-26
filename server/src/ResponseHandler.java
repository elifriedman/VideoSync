public class ResponseHandler {
  private double time;
  private double vidtime;
  private String vidpaused;
  public ResponseHandler() {
    time = 0;
    vidtime = 0;
  }

  private String processRequest(String request) {
    String response = "";
    String[] cats = request.split("&");
    if(cats[0].equals("master")) {
      time = System.currentTimeMillis();
      vidtime = Double.parseDouble(cats[1]);
      vidpaused = cats[2]; 
      response="OK"; //Not important
    } else if(cats[0].equals("slave")) {
      double tdiff = (System.currentTimeMillis()-time)/1000;
      if(!vidpaused.equals("true")) {
        response = "" + (tdiff + vidtime) +  "," + vidpaused;
      } else {
        response = "" + vidtime +  "," + vidpaused;
      }
    }
    return response;
  }

  public String handleRequest(String request) {
    int qm = request.lastIndexOf('?');
    if(qm == -1)
      return "";
    String q = request.substring(qm);
    if(q.length() > 1) q = q.substring(1);
    String response = processRequest(q);
    return response;
  }
}
