//import database.Connector;
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//import java.sql.ResultSet;
//
//public class Main extends Application {
//    public static Stage rootStage;
//
//    public static void main(String[] args) {
//        String sql= "select * from students";
//        Connector connect=  Connector.getInstance();
//        try {
//            ResultSet rs1 = connect.getConn().createStatement().executeQuery(sql);
//            while (rs1.next()){
//                int id= rs1.getInt("id");
//                String name = rs1.getString("fullname");
//                System.out.println(id+ "-"+ name);
//            }
//        }catch (Exception e){
//
//        }
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        rootStage= primaryStage;
//        Parent root = FXMLLoader.load(getClass().getResource("../javaFx/HomePage.fxml"));
//        primaryStage.setScene(new Scene(root,830,550));
//        primaryStage.setTitle("Project java2");
//        primaryStage.show();
//    }
//}