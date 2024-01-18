package week2.day_4;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Product p1 = new Product(0, "Le avventure di jo","Books", 105);
        Product p2 = new Product(1, "Sono Adam","Books", 115);
        Product p3 = new Product(2, "Libro","Books", 55);
        Product p4 = new Product(3, "Pensieri di un minatore","Books", 77);
        Product p5 = new Product(4, "Fasciatoio","Baby", 77);
        Product p6 = new Product(5, "biberon","Baby", 5);
        Product p7 = new Product(6, "Poster Juventus","Boys", 3);
        Product p8 = new Product(7, "Monopattino elettrico","Boys", 250);

        Costumer c1 = new Costumer(0, "Marco Ziino", 2);
        Costumer c2 = new Costumer(1, "Fernando Crisafulli", 2);
        Costumer c3 = new Costumer(2, "Letizia Magellano", 1);
        Costumer c4 = new Costumer(3, "Lorenzo Afragola", 2);


        Order o1 = new Order(0, "delivered", LocalDate.parse("2021-02-01"),LocalDate.parse("2023-04-05"), c1);
        Order o2 = new Order(1, "delivered", LocalDate.parse("2021-02-15"),LocalDate.parse("2023-04-05"), c1);
        Order o3 = new Order(2, "delivered", LocalDate.parse("2021-03-01"),LocalDate.parse("2023-04-05"), c2);
        Order o4 = new Order(3, "delivered", LocalDate.parse("2023-04-05"),LocalDate.parse("2023-04-05"), c2);
        Order o5 = new Order(4, "delivered", LocalDate.parse("2023-04-05"),LocalDate.parse("2023-04-05"), c3);
        Order o6 = new Order(5, "delivered", LocalDate.parse("2023-04-05"),LocalDate.parse("2023-04-05"), c3);
        Order o7 = new Order(6, "delivered", LocalDate.parse("2023-04-05"),LocalDate.parse("2023-04-05"), c4);
        Order o8 = new Order(7, "delivered", LocalDate.parse("2023-04-05"),LocalDate.parse("2023-04-05"), c4);


        o1.addProduct(p1);
        o2.addProduct(p2);
        o3.addProduct(p3);
        o4.addProduct(p4);
        o5.addProduct(p5);
        o6.addProduct(p6);
        o7.addProduct(p7);
        o8.addProduct(p8);


        List<Product> productList = List.of(p1,p2,p3,p4,p5,p6,p7,p8);
        List<Order> orderList = List.of(o1,o2,o3,o4,o5,o6,o7,o8);
        saveProductDisc(productList);
        leggiProdottiNelDisco();


        //Esercizio1##
        Map<Costumer,List<Order>> orderForClient = orderList.stream().collect(Collectors.groupingBy(Order::getCostumer));

        //Esercizio2##
        Map<Costumer, Double> costOrderClient =  orderList.stream().collect(Collectors.
                groupingBy(Order::getCostumer, Collectors.summingDouble(o->o.getProducts().stream()
                        .mapToDouble(Product::getPrice).sum())));
        //Esercizio3##

        Product pMaxPrice = productList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))).get();

        //Esercizio4##
        Double costoMedioOrderClient = orderList.stream().collect(Collectors.averagingDouble(o->o.getProducts().stream().mapToDouble(Product::getPrice).sum()));

        //Esercizio5##

        Map<String, Double> costoForCategories = productList.stream().
                collect(Collectors.groupingBy(Product::getCategory, Collectors.summingDouble(Product::getPrice)));



        //System.out.println(orderForClient);
        //System.out.println(costOrderClient);
        //System.out.println(orderList);
        System.out.println(pMaxPrice);
        System.out.println(costoForCategories);

        System.out.println("La media dei prezzi della lista degli ordini è: "+costoMedioOrderClient);
    }

    public static void printListP(List<Product> list){
        for (Product i:list){
            System.out.println(i);
        }
    }
    public static void printListO(List<Order> list){
        for (Order i:list){
            System.out.println(i);
        }
    }

    public static void saveProductDisc(List<Product>list) {

       try {
           File file = new File("dirProdotti/prodotti.txt");
           String products = list.stream().map(p->p.getName()+"@"+p.getCategory()+"@"+p.getPrice()).collect(Collectors.joining("#"));
           FileUtils.writeStringToFile(file, products, Charset.defaultCharset(), true);
       }catch (IOException e){
           System.out.println(e.getMessage());
       }
    }

    public static ArrayList<Product> leggiProdottiNelDisco(){

      try {
          File file = new File("dirProdotti/prdotti.txt");
          String strgProducts = FileUtils.readFileToString(file, Charset.defaultCharset());

          String[] strgProduct = strgProducts.split("#");

          ArrayList<Product> prodotti = Arrays.stream(strgProduct).map(s -> {
              String[] strgSingleProd = s.split("@");
              Product p = new Product(new Random().nextLong(),
                      strgSingleProd[0],
                      strgSingleProd[1],
                      Double.parseDouble(strgSingleProd[2]));
              return p;
          }).collect(Collectors.toCollection(ArrayList::new));

          return prodotti;
      }catch (IOException e){
          System.out.println(e.getMessage());
      }
    }
}
