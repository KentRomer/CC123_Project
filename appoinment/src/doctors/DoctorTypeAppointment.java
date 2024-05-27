package doctors;

import constant.commonconstant;
import gui.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DoctorTypeAppointment extends doctors{

    private String loggedInLastName;
    private String loggedInFirstName;
    private String loggedInMiddleName;
    private int age;
    private int number;
    private String address;
    private int id;
    private String sex;
    private String email;

    public DoctorTypeAppointment() {
        super("Health Apoointment");
        addDoctorComponents();
        retrieveUnconfirmedNotifications();

    }

    private void addDoctorComponents() {

        JButton profile = new JButton("Profile");
        profile.setFont(new Font("DIALOG", Font.BOLD,20));
        profile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        profile.setForeground(commonconstant.SECONDARY_COLOR);
        profile.setBackground(commonconstant.DARK_BLUE);
        profile.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            super.mouseClicked(e);
            DoctorTypeAppointment.this.dispose();
            new UserProfile(id, loggedInLastName, loggedInFirstName, loggedInMiddleName, sex, age, number, email, address).setVisible(true);
    }
});
        profile.setBounds(1070,120,120,30);

        JButton aboutUs = new JButton("About us");
        aboutUs.setFont(new Font("DIALOG", Font.BOLD, 20));
        aboutUs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        aboutUs.setForeground(commonconstant.SECONDARY_COLOR);
        aboutUs.setBackground(commonconstant.DARK_BLUE);
        aboutUs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
               super.mouseClicked(e);
               DoctorTypeAppointment.this.dispose();
                new About().setVisible(true);
            }
        });
        aboutUs.setBounds(1070,170,120,30);

        JButton contactUs = new JButton("Contact Us");
        contactUs.setFont(new Font("Dialog", Font.BOLD, 18));
        contactUs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        contactUs.setForeground(commonconstant.SECONDARY_COLOR);
        contactUs.setBackground(commonconstant.DARK_BLUE);
        contactUs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DoctorTypeAppointment.this.dispose();
                new ContactUs().setVisible(true);
            }
        });
        contactUs.setBounds(1065,220,130,30);

        JButton logout = new JButton("Logout");
        logout.setFont(new Font("DIALOG", Font.BOLD, 18));
        logout.setForeground(commonconstant.SECONDARY_COLOR);
        logout.setBackground(commonconstant.DARK_BLUE);
        logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
              super.mouseClicked(e);
              DoctorTypeAppointment.this.dispose();
              new loginpage().setVisible(true);
            }
        });
        logout.setBounds(1065,270,130,30);

        add(profile);
        add(aboutUs);
        add(contactUs);
        add(logout);

        ImageIcon doctor = new ImageIcon("appoinment/src/image/DR KHEN.png");
        JLabel logolabel = new JLabel(doctor);
        logolabel.setBounds(80,180,170,170);

        ImageIcon doctor1 = new ImageIcon("appoinment/src/image/DR FAITH.png");
        JLabel logolabel1 = new JLabel(doctor1);
        logolabel1.setBounds(535,180,170,170);

        ImageIcon doctor2 = new ImageIcon("appoinment/src/image/DR BRYLL.png");
        JLabel logolabel2 = new JLabel(doctor2);
        logolabel2.setBounds(80,400,170,170);

        ImageIcon doctor3 = new ImageIcon("appoinment/src/image/DR SHER.png");
        JLabel logolabel3 = new JLabel(doctor3);
        logolabel3.setBounds(535,400,170,170);


        add(logolabel);
        add(logolabel1);
        add(logolabel2);
        add(logolabel3);


        JLabel text = new JLabel("We're bridging the gap between Doctors and Patients");
        text.setBounds(-40, -130, 1000, 400);
        text.setForeground(commonconstant.TEXT_COLOR.brighter());
        text.setFont(new Font("Dialog", Font.BOLD, 30));
        text.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel text1 = new JLabel("You'll never miss another Doctor's appointment!");
        text1.setBounds(-40, 60, 700, 100);
        text1.setForeground(commonconstant.TEXT_COLOR.brighter());
        text1.setFont(new Font("Dialog", Font.BOLD, 20));
        text1.setHorizontalAlignment(SwingConstants.CENTER);

        /*JLabel text2= new JLabel("Doctor Online Now");
        text2.setBounds(16, 80, 600, 400);
        text2.setForeground(commonconstant.DARKERGREEN_REG.brighter());
        text2.setFont(new Font("Dialog", Font.BOLD, 60));
        text2.setHorizontalAlignment(SwingConstants.CENTER);*/

        add(text);
        add(text1);
      //  add(text2);

        JLabel doctorn1= new JLabel("Dr. Khen Lloyed Baylon");
        doctorn1.setBounds(160, 150, 400, 100);
        doctorn1.setForeground(commonconstant.TEXT_COLOR.brighter());
        doctorn1.setFont(new Font("Dialog", Font.BOLD, 20));
        doctorn1.setHorizontalAlignment(SwingConstants.CENTER);


        JLabel servicen1= new JLabel("OPTHALMOLOGIST");
        servicen1.setBounds(160, 180, 400, 100);
        servicen1.setForeground(commonconstant.TEXT_COLOR.brighter());
        servicen1.setFont(new Font("Dialog", Font.BOLD, 15));
        servicen1.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel doctorn2= new JLabel("Dr. Chelsie Faith Maranga");
        doctorn2.setBounds(620, 150, 400, 100);
        doctorn2.setForeground(commonconstant.TEXT_COLOR.brighter());
        doctorn2.setFont(new Font("Dialog", Font.BOLD, 20));
        doctorn2.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel servicen2= new JLabel("PEDIATRICS");
        servicen2.setBounds(620, 180, 400, 100);
        servicen2.setForeground(commonconstant.TEXT_COLOR.brighter());
        servicen2.setFont(new Font("Arial", Font.BOLD, 15));
        servicen2.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel doctorn3= new JLabel("Dr. John Brylle Crodua");
        doctorn3.setBounds(160, 360, 400, 100);
        doctorn3.setForeground(commonconstant.TEXT_COLOR.brighter());
        doctorn3.setFont(new Font("Dialog", Font.BOLD, 20));
        doctorn3.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel servicen3= new JLabel("FAMILY MEDICINE");
        servicen3.setBounds(160, 390, 400, 100);
        servicen3.setForeground(commonconstant.TEXT_COLOR.brighter());
        servicen3.setFont(new Font("Arial", Font.BOLD, 15));
        servicen3.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel doctorn4= new JLabel("Dr. Sherilyn Sanchez");
        doctorn4.setBounds(620, 360, 400, 100);
        doctorn4.setForeground(commonconstant.TEXT_COLOR.brighter());
        doctorn4.setFont(new Font("Dialog", Font.BOLD, 20));
        doctorn4.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel servicen4= new JLabel("OBSTETRICS GYNECOLOGY");
        servicen4.setBounds(620, 390, 400, 100);
        servicen4.setForeground(commonconstant.TEXT_COLOR.brighter());
        servicen4.setFont(new Font("Arial", Font.BOLD, 15));
        servicen4.setHorizontalAlignment(SwingConstants.CENTER);


        add(doctorn1);
        add(servicen1);
        add(doctorn2);
        add(servicen2);
        add(doctorn3);
        add(servicen3);
        add(doctorn4);
        add(servicen4);

        /*ImageIcon logoIcon1= new ImageIcon("appoinment/src/image/d11.png");
        JLabel logoLabel1 = new JLabel(logoIcon1);
        logoLabel1.setBounds(100, 0, 50, 100);

        ImageIcon logoIcon2= new ImageIcon("appoinment/src/image/d1.png");
        JLabel logoLabel2 = new JLabel(logoIcon2);

        ImageIcon logoIcon3= new ImageIcon("appoinment/src/image/d1.png");
        JLabel logoLabel3 = new JLabel(logoIcon3);
        logoLabel3.setBounds(100, 0, 1000, 1000);

        ImageIcon logoIcon4= new ImageIcon("appoinment/src/image/d1.png");
        JLabel logoLabel4 = new JLabel(logoIcon4);
        logoLabel4.setBounds(100, 0, 1000, 1000);


        add(logoLabel1);
        add(logoLabel2);
        add(logoLabel3);
        add(logoLabel4);
*/

        JButton consult1= new JButton("Consult Now");
        consult1.setFont(new Font("Dialog", Font.BOLD, 18));
        consult1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        consult1.setForeground(commonconstant.SECONDARY_COLOR);
        consult1.setBackground(commonconstant.DARKERGREEN_REG);
        consult1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DoctorTypeAppointment.this.dispose();
                new PatientProfile1().setVisible(true);
            }
        });

        consult1.setBounds(275, 295, 220,70);
        add(consult1);


        JButton consult2= new JButton("Consult Now");
        consult2.setFont(new Font("Dialog", Font.BOLD, 18));
        consult2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        consult2.setForeground(commonconstant.SECONDARY_COLOR);
        consult2.setBackground(commonconstant.DARKERGREEN_REG);
        consult2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DoctorTypeAppointment.this.dispose();
                new loginpage().setVisible(true);
            }
        });

        consult2.setBounds(730, 295, 220,70);
        add(consult2);

        JButton consult3= new JButton("Consult Now");
        consult3.setFont(new Font("Dialog", Font.BOLD, 18));
        consult3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        consult3.setForeground(commonconstant.SECONDARY_COLOR);
        consult3.setBackground(commonconstant.DARKERGREEN_REG);
        consult3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DoctorTypeAppointment.this.dispose();
                new loginpage().setVisible(true);
            }
        });

        consult3.setBounds(275, 510, 220,70);
        add(consult3);


        JButton consult4= new JButton("Consult Now");
        consult4.setFont(new Font("Dialog", Font.BOLD, 18));
        consult4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        consult4.setForeground(commonconstant.SECONDARY_COLOR);
        consult4.setBackground(commonconstant.DARKERGREEN_REG);
        consult4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DoctorTypeAppointment.this.dispose();
                new loginpage().setVisible(true);
            }
        });

        consult4.setBounds(730, 510, 220,70);
        add(consult4);




        JPanel doctorpanel1 = new JPanel();
        doctorpanel1.setLayout(null); // Set the layout to null to allow positioning components manually
        doctorpanel1.setBounds(75, 165, 420, 200); // Set the bounds of the panel
        doctorpanel1.setBackground(new Color(255, 255, 255, 100));
        add(doctorpanel1);

        JPanel doctorpanel2 = new JPanel();
        doctorpanel2.setLayout(null); // Set the layout to null to allow positioning components manually
        doctorpanel2.setBounds(75, 380, 420, 200); // Set the bounds of the panel
        doctorpanel2.setBackground(new Color(255, 255, 255, 100));
        add(doctorpanel2);

        JPanel doctorpanel3 = new JPanel();
        doctorpanel3.setLayout(null); // Set the layout to null to allow positioning components manually
        doctorpanel3.setBounds(530, 165, 420, 200); // Set the bounds of the panel
        doctorpanel3.setBackground(new Color(255, 255, 255, 100));
        add(doctorpanel3);

        JPanel doctorpanel4 = new JPanel();
        doctorpanel4.setLayout(null); // Set the layout to null to allow positioning components manually
        doctorpanel4.setBounds(530, 380, 420, 200); // Set the bounds of the panel
        doctorpanel4.setBackground(new Color(255, 255, 255, 100));

        add(doctorpanel1);
        add(doctorpanel2);
        add(doctorpanel3);
        add(doctorpanel4);



        ImageIcon background = new ImageIcon("appoinment/src/image/medicalbg.png");
        JLabel backgroundlabel = new JLabel(background);
        backgroundlabel.setBounds(0,0,1250,800);

        add(backgroundlabel);


    }
    // In the DoctorTypeAppointment class
    private void retrieveUnconfirmedNotifications() {
        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_NOTIFICATION, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT id, message FROM " + commonconstant.NOTIFICATION + " WHERE confirmed = false");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int notificationId = resultSet.getInt("id");
                String notificationMessage = resultSet.getString("message");
                int response = JOptionPane.showConfirmDialog(this, notificationMessage, "Confirm Appointment", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    confirmAppointment(notificationId);
                } else {
                    declineAppointment(notificationId);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void confirmAppointment(int notificationId) {
        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_NOTIFICATION, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement("UPDATE " + commonconstant.NOTIFICATION + " SET confirmed = true WHERE id = ?");
            statement.setInt(1, notificationId);
            statement.executeUpdate();
            // Additional logic to store the appointment in the main database
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void declineAppointment(int notificationId) {
        try {
            Connection connection = DriverManager.getConnection(commonconstant.DB_NOTIFICATION, commonconstant.DB_USERNAME, commonconstant.DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement("DELETE FROM " + commonconstant.NOTIFICATION + " WHERE id = ?");
            statement.setInt(1, notificationId);
            statement.executeUpdate();
            // Additional logic to notify the user that the appointment was declined
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
