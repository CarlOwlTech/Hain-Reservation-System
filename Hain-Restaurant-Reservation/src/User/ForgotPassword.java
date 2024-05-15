
package User;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlo
 */
public class ForgotPassword extends javax.swing.JFrame {


    public ForgotPassword() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Login = new javax.swing.JLabel();
        Home = new javax.swing.JLabel();
        Exit = new javax.swing.JLabel();
        Header = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        LogIn = new javax.swing.JLabel();
        passHide = new javax.swing.JLabel();
        passVisible = new javax.swing.JLabel();
        loginbtn = new button.Button();
        username = new textfield.TextField();
        answer = new textfield.TextField();
        passTxt = new textfield.PasswordField();
        securityQuestion = new combobox.Combobox();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(100, 100));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setMaximumSize(new java.awt.Dimension(1280, 720));
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Logintxt.png"))); // NOI18N
        Login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginMouseClicked(evt);
            }
        });
        jPanel1.add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 43, 120, 60));

        Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/HomeUL.png"))); // NOI18N
        Home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeMouseClicked(evt);
            }
        });
        jPanel1.add(Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 43, 120, 60));

        Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/windows close.png"))); // NOI18N
        Exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitMouseClicked(evt);
            }
        });
        jPanel1.add(Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 0, -1, -1));

        Header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Header.png"))); // NOI18N
        Header.setText("jLabel1");
        jPanel1.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 120));

        jLabel1.setFont(new java.awt.Font("Segoe UI Historic", 2, 18)); // NOI18N
        jLabel1.setText("Already have account?");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 620, 190, 30));

        LogIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/sLogin.png"))); // NOI18N
        LogIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogInMouseClicked(evt);
            }
        });
        jPanel1.add(LogIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 620, 90, 30));

        passHide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/bigHide.png"))); // NOI18N
        passHide.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        passHide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passHideMousePressed(evt);
            }
        });
        jPanel1.add(passHide, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 495, -1, -1));

        passVisible.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/bigVisible.png"))); // NOI18N
        passVisible.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        passVisible.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                passVisibleMouseReleased(evt);
            }
        });
        jPanel1.add(passVisible, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 495, -1, -1));

        loginbtn.setText("Update");
        loginbtn.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        loginbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginbtnMouseExited(evt);
            }
        });
        loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbtnActionPerformed(evt);
            }
        });
        jPanel1.add(loginbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 560, 240, 60));

        username.setLabelText("Username");
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 400, 50));

        answer.setLabelText("Your Answer");
        jPanel1.add(answer, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 400, 50));

        passTxt.setEchoChar('*');
        passTxt.setLabelText("New Password");
        jPanel1.add(passTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 400, -1));

        securityQuestion.setMaximumRowCount(10);
        securityQuestion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "What is the name of your favorite pet?", "What high school did you attend?", "In what city were you born?", "What was the name of your elementary school?", "What is your dream job?" }));
        securityQuestion.setSelectedIndex(-1);
        securityQuestion.setLabeText("Security Question");
        jPanel1.add(securityQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 400, 50));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Signup_1.png"))); // NOI18N
        Background.setOpaque(true);
        jPanel1.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1180, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginMouseClicked
        Login login = new Login();
        login.setVisible(true);
        dispose();

    }//GEN-LAST:event_LoginMouseClicked

    private void HomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseClicked
        LandingPage lp = new LandingPage();
        lp.setVisible(true);
        dispose();
    }//GEN-LAST:event_HomeMouseClicked

    private void LogInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogInMouseClicked
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_LogInMouseClicked

    private void passHideMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passHideMousePressed
        passHide.setVisible(false);
        passVisible.setVisible(true);
        passTxt.setEchoChar((char) 0);
    }//GEN-LAST:event_passHideMousePressed

    private void passVisibleMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passVisibleMouseReleased
        passHide.setVisible(true);
        passVisible.setVisible(false);
        passTxt.setEchoChar('*');
    }//GEN-LAST:event_passVisibleMouseReleased

    private void loginbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginbtnMouseEntered
        loginbtn.setBackground(new Color(153, 255, 153));
        loginbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_loginbtnMouseEntered

    private void loginbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginbtnMouseExited
        loginbtn.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_loginbtnMouseExited

    private void ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseClicked
        ImageIcon smile = new ImageIcon(getClass().getResource("/LP_images/Smile.png"));
        ImageIcon exit = new ImageIcon(getClass().getResource("/LP_images/ExitIcon.png"));
        Object[] options = {"Yes", "No"};

        int response = JOptionPane.showOptionDialog(
                null,
                "Do you want to exit?",
                "Hain Reservation System",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                exit,
                options,
                options[0]
        );

        if (response == 0) {
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null, "Enjoy Using the Application!", "Hain Reservation System", JOptionPane.INFORMATION_MESSAGE, smile);
        }
    }//GEN-LAST:event_ExitMouseClicked

    private void loginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbtnActionPerformed
        ImageIcon error = new ImageIcon(getClass().getResource("/LP_images/Error_1.png"));
        ImageIcon success = new ImageIcon(getClass().getResource("/LP_images/Success.png"));
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/haindatabase", "root", "carlo123")) {

                AccountInfo userInfo = new AccountInfo();
                userInfo.setUsername(username.getText());
                userInfo.setSecurityQuestion(securityQuestion.getSelectedItem().toString());
                userInfo.setSecurityAnswer(answer.getText());
    

                String ques = securityQuestion.getSelectedItem().toString();
                String query = "SELECT * FROM useraccounts WHERE username = ? AND SecurityQuestion = ? AND Answers = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, userInfo.getUsername());
                ps.setString(2, userInfo.getSecurityQuestion());
                ps.setString(3, userInfo.getSecurityAnswer());
                ResultSet rs = ps.executeQuery();

                
                if (!rs.next()) {
                    JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again.", "Error", JOptionPane.ERROR_MESSAGE, error);
                } else {
 
                    String updateQuery = "UPDATE useraccounts SET password = ? WHERE username = ?";
                    PreparedStatement updatePs = con.prepareStatement(updateQuery);
                    updatePs.setString(1, passTxt.getText());
                    updatePs.setString(2, username.getText());



                    int affectedRows = updatePs.executeUpdate();
                    System.out.print("Wrong!");

                    if (affectedRows > 0) {
                        JOptionPane.showMessageDialog(null, "Password successfully updated!", "Forgot Password", JOptionPane.INFORMATION_MESSAGE, success);
                        username.setText("");
                        securityQuestion.setSelectedIndex(-1);
                        answer.setText("");
                        passTxt.setText("");
                    } else if (passTxt.getText().length() < 6) {
                        JOptionPane.showMessageDialog(null, "Password must be at least 6!", "Forgot Password", JOptionPane.ERROR_MESSAGE, error);
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to update password. Please try again.", "Error", JOptionPane.ERROR_MESSAGE,error);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Fill out all Feilds", "Error", JOptionPane.ERROR_MESSAGE, error);
        }


    }//GEN-LAST:event_loginbtnActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel Exit;
    private javax.swing.JLabel Header;
    private javax.swing.JLabel Home;
    private javax.swing.JLabel LogIn;
    private javax.swing.JLabel Login;
    private textfield.TextField answer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private button.Button loginbtn;
    private javax.swing.JLabel passHide;
    private textfield.PasswordField passTxt;
    private javax.swing.JLabel passVisible;
    private combobox.Combobox securityQuestion;
    private textfield.TextField username;
    // End of variables declaration//GEN-END:variables
}
