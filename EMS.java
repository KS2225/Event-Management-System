import java.sql.*;
import java.util.Scanner;
import java.sql.Date;


public class EMS {
	public static void main(String[] args) {
		try {
				/* load driver*/
				Class.forName("com.mysql.cj.jdbc.Driver");
				/*create connection*/
				Connection con = DriverManager.getConnection(<localhost link to database>,"root",<mysql password>);
				System.out.println("Connected to the database");
				/* send sql statements to database*/
				Statement sm = con.createStatement();
				int ch,cho,ch1,ch2 = 0;
				/*get input*/
				Scanner s = new Scanner(System.in);
				do
				{
				System.out.println("\n\t\t\t\tWelcome To EMS!!!\n1.Sign Up\n2.Sign in\n3.EXIT\nEnter your choice: ");
				cho=s.nextInt();
			{
				switch(cho)
					{
						case 1:
						{
							System.out.println("\nEnter Details: ");
							System.out.println("Enter your First Name: ");
							String a1=s.next();
							System.out.println("Enter your Last Name: ");
							String a2=s.next();
							System.out.println("Enter your User Id: ");
							int b0=s.nextInt();
							System.out.println("Enter your Phone number: ");
							int b=s.nextInt();
							System.out.println("Enter your email-id: ");
							String c=s.next();
							System.out.println("Enter your location: ");
							String d=s.next();
							System.out.println("Enter user type(guest/creator): ");
							String e=s.next();
							System.out.println("Enter your password: ");
							String c2=s.next();
							String sql1 = "Insert into users values('"+a1+"','"+a2+"','"+b0+"','"+b+"','"+c+"','"+d+"','"+e+"','"+c2+"');";
						sm.executeUpdate(sql1);
						//add query for existing account
						System.out.println("\nAccount Created!");
						break;
						}
						case 2:
						{
							try 
							{
								System.out.println("Enter your email-id: ");
								String c3=s.next();
								System.out.println("Enter your password: ");
								String c4=s.next();
								String sql2 = "SELECT * FROM users where user_mail='"+c3+"' and user_pass='"+c4+"'";
						        ResultSet results = sm.executeQuery(sql2); 
						         
						        if(!results.next()) 
						        {
					              System.out.println("Wrong Username and Password.");  
						        }
						        String sqlgu = "SELECT user_type FROM users where user_type='guest' and user_mail='"+c3+"'";
						        ResultSet results2 = sm.executeQuery(sqlgu);
						        
						        if(results2.next()) 
						        {
						        	int chg;
									do 
						        	{
						        	System.out.println("\nMENU:\n1.Search Event\n2.EXIT\nEnter your choice: ");
						        	chg=s.nextInt();
						        	switch(chg) 
						        	{
						        	case 1:
					        			System.out.println("Enter Event Type: ");
										String c5=s.next();
										String sqlut = "SELECT * FROM event where event_type='"+c5+"'";
								        ResultSet resultsut = sm.executeQuery(sqlut);
								        while(resultsut.next())
										{
											String gname1 =resultsut.getString("event_name");
											String gdate =resultsut.getString("event_date");
											String gtime =resultsut.getString("event_time");
											String gvenue =resultsut.getString("event_venue");
											System.out.print("\nEvent Name: " +gname1);
											System.out.print("\nDate: " +gdate);
											System.out.print("\nTime: " +gtime);
											System.out.print("\nVenue: " +gvenue);
											System.out.print("\n");
										}
								        break;
									}
						        	}while(chg<2);
						        }
						        String sqlsel = "SELECT * FROM users where user_type='creator' and user_mail='"+c3+"'";
						        ResultSet resultsel = sm.executeQuery(sqlsel);
						        if(resultsel.next())
						        {
						        	do
						        	{
						        	System.out.println("\nMENU:\n1.Create Event\n2.Choose team\n3.Check Report\n4.Update Profile\n5.EXIT\nEnter your choice: ");
									ch=s.nextInt();
									switch(ch)
									{
									case 1:
										do {
										System.out.println("\nMENU for Create Event\n1.INSERT\n2.Display Event Details\n3.UPDATE Details\n4.DELETE Event\n5.EXIT\nEnter your choice: ");
										ch1=s.nextInt();
										switch(ch1) {
										case 1:
											System.out.println("Enter Event Id: ");
											int g0=s.nextInt();
											System.out.println("\nEnter Event Name: ");
											String g=s.next();
											System.out.println("\nEnter Event Type:\nWedding\nMemorial\nParty\nWildlife\nAdventure\n ");
											String h=s.next();
											System.out.println("\nEnter Event Venue: ");
											String j = s.next();
											System.out.println("\nEnter Event Date: ");
											String k = s.next();
											Date edate=Date.valueOf(k);
											System.out.println("\nEnter Event Time: ");
											String l = s.next();
											Time etime=Time.valueOf(l);
											String sql1 = "Insert into event(event_name, event_type, event_venue, event_date, event_time) values('"+g+"','"+h+"','"+j+"','"+edate+"','"+etime+"');";
											/*execute query*/
											sm.executeUpdate(sql1);
											do {
											System.out.println("\nWould you like to see suggestions for your event?");
											int m = s.nextInt();
											if(m==1)
											{
											
											System.out.println("Show suggestions for:\n1.Bakery\n2.Catering\n3.Equipments\n4.Decorations\n5.Furniture\n6.Exit\nEnter your choice: ");
											ch2 = s.nextInt();
											switch(ch2) 
												{
												case 1:
													 	String sql = "SELECT * FROM bakery";
														/*store database records*/
														ResultSet rs = sm.executeQuery(sql);  
														while(rs.next())
														{
															int bid = rs.getInt("Bakery_id");
															String bname1 =rs.getString("Bakery_name");
															String bven =rs.getString("Bakery_venue");
															int bcap = rs.getInt("Bakery_capacity");
															System.out.print("\nBakery Id: " +bid);
															System.out.print("\nBakery Name: " +bname1);
															System.out.print("\nBakery Venue: " +bven);
															System.out.print("\nBakery Capacity: " +bcap);
															System.out.print("\n");
														}
														break;
														
												case 2:
													    String sql21 = "SELECT * FROM catering";
														/*store database records*/
														ResultSet rs2 = sm.executeQuery(sql21);  
														while(rs2.next())
														{
															int cid = rs2.getInt("Cat_id");
															String cname1 =rs2.getString("Cat_name");
															String cven =rs2.getString("Cat_venue");
															int ccap = rs2.getInt("Cat_capacity");
															System.out.print("\nCatering Id: " +cid);
															System.out.print("\nCatering Name: " +cname1);
															System.out.print("\nCatering Venue: " +cven);
															System.out.print("\nCatering Capacity: " +ccap);
															System.out.print("\n");
														}
														break;
														
												case 3:
													 String sql3 = "SELECT * FROM equipment";
														/*store database records*/
														ResultSet rs3 = sm.executeQuery(sql3);  
														while(rs3.next())
														{
															int eid = rs3.getInt("Equipment_id");
															String ename1 =rs3.getString("Equipment_name");
															String even =rs3.getString("Equipment_venue");
															int ecap = rs3.getInt("Equipment_capacity");
															System.out.print("\nEquipment Id: " +eid);
															System.out.print("\nEquipment Name: " +ename1);
															System.out.print("\nEquipment Venue: " +even);
															System.out.print("\nEquipment Capacity: " +ecap);
															System.out.print("\n");
														}
														break;
														
												case 4:
													  String sql4 = "SELECT * FROM decorations";
														/*store database records*/
														ResultSet rs4 = sm.executeQuery(sql4);  
														while(rs4.next())
														{
															int did = rs4.getInt("Decoration_id");
															String dname1 =rs4.getString("Decoration_name");
															String dven =rs4.getString("Decoration_venue");
															int dcap = rs4.getInt("Decoration_capacity");
															System.out.print("\nDecoration Id: " +did);
															System.out.print("\nDecoration Name: " +dname1);
															System.out.print("\nDecoration Venue: " +dven);
															System.out.print("\nDecoration Capacity: " +dcap);
															System.out.print("\n");
														}
														break;
												case 5:
													  String sql5 = "SELECT * FROM furniture";
														/*store database records*/
														ResultSet rs5 = sm.executeQuery(sql5);  
														while(rs5.next())
														{
															int fid = rs5.getInt("Furniture_id");
															String fname1 =rs5.getString("Furniture_name");
															String fven =rs5.getString("Furniture_venue");
															int fcap = rs5.getInt("Furniture_capacity");
															System.out.print("\nFurniture Id: " +fid);
															System.out.print("\nFurniture Name: " +fname1);
															System.out.print("\nFurniture Venue: " +fven);
															System.out.print("\nFurniture Capacity: " +fcap);
															System.out.print("\n");
														}
														break;
												}
											}
											else
											{
												System.out.print("done");
											}
										}while(ch2<6);
											System.out.println("\nEvent is Inserted!");		
										break;
					
										case 2: String sql22 = "SELECT * FROM event";
										/*store database records*/
										ResultSet rs6 = sm.executeQuery(sql22);  
										while(rs6.next())
										{
											/*get database records*/
											int id = rs6.getInt("Event_id");
											String name1 =rs6.getString("Event_name");
											String even =rs6.getString("Event_venue");
											String etype =rs6.getString("Event_type");
											String edate1 =rs6.getString("Event_date");
											String etime1 =rs6.getString("Event_time");
											//type,venue,date,time
											System.out.print("\nEvent ID: " +id);
											System.out.print("\nEvent Name: " +name1);
											System.out.print("\nEvent Venue: " +even);
											System.out.print("\nEvent Type: " +etype);
											System.out.print("\nEvent Date: " +edate1);
											System.out.print("\nEvent Time: " +etime1);
											System.out.print("\n");
										}
										break;
										
										case 3: 
											System.out.println("\nEnter the Event ID for which you want to update Event Venue: ");
											int i1=s.nextInt();
											System.out.println("\nEnter the Event Venue to be updated: ");
											String n1=s.next();
											System.out.println("\nEnter Event Date to be updated: ");
											String euk = s.next();
											Date eudate=Date.valueOf(euk);
											System.out.println("\nEnter Event Time to be updated: ");
											String eul = s.next();
											Time eutime=Time.valueOf(eul);
											String sql3 = "update event set event_venue='"+n1+"' ,event_date='"+eudate+"' ,event_time='"+eutime+"' where event_id='"+i1+"';";
										sm.executeUpdate(sql3);
										System.out.println("Record is updated");
										break;
										
										case 4:  	
											System.out.println("\nEnter the Event ID: ");
											int i2=s.nextInt();
											String sql4 = "delete from event where Event_id='"+i2+"';";
										sm.executeUpdate(sql4);
										System.out.println("\nRecord is deleted");
										break;
										}
										}while(ch1<5);	
										break;
									
									case 2:
										//team
										System.out.println("\nEnter the Team ID: ");
										int team=s.nextInt();
										System.out.println("\nEnter number of team members: ");
										int n=s.nextInt();
										for(int i =0; i<n;i++ )
										{
											System.out.println("\nEnter Name: ");
											String o=s.next();
											System.out.println("\nEnter Job: ");
											String q=s.next();
											System.out.println("\nEnter Salary: ");
											float p=s.nextFloat();
											String sql7 = "Insert into teams values('"+team+"','"+o+"','"+q+"','"+p+"');";
											sm.executeUpdate(sql7);
										}
										break;
									case 3:
										System.out.println("\nEnter User Id: ");
										String q=s.next();
										//report id, user id, event id, event name, eve type, #team mems, review 1 2
										String sql22 = "SELECT report_id FROM report";
										String sql24 = "SELECT event_id,event_name,event_type FROM event";
										System.out.print("\nUser ID " +q);
										//store database records/
										ResultSet rs7 = sm.executeQuery(sql22);
										while(rs7.next())
										{
											int id = rs7.getInt("report_id");
											System.out.print("\nReport ID: " +id);
										}
										ResultSet rs9 = sm.executeQuery(sql24);
										while(rs9.next())
										{
											int id = rs9.getInt("event_id");
											String name = rs9.getString("event_name");
											String type = rs9.getString("event_id");
											System.out.print("\nEvent ID: " +id);
											System.out.print("\nEvent Name: " +name);
											System.out.print("\nEvent Type: " +type);
										}
									break;
									case 4:
										int ch5;
										//update profile
										do {
										System.out.println("\nWhat would you like to update:\n1.Name\n2.Email ID\n3.Phone Number\n4.Location\n5.User Type\n6.Password");
										ch5 =s.nextInt();
										
										/*store database records*/
										
										switch(ch5)
										{
										
										case 1:
											System.out.println("\nEnter the User ID for Verification: ");
											int uid=s.nextInt();
											System.out.println("\nEnter First Name to be updated: ");
											String n1=s.next();
											System.out.println("\nEnter Last Name to be updated: ");
											String n2=s.next();
											String sql40 = "update users set F_name='"+n1+"', S_name='"+n2+"' where user_id='"+uid+"';";
										sm.executeUpdate(sql40);
										System.out.println("Record is updated");
										
										break;
										case 2:
											System.out.println("\nEnter the User ID for Verification: ");
											uid=s.nextInt();
											 
												System.out.println("\nEnter Email ID to be updated: ");
												String em=s.next();
												String sql5 = "update users set user_mail='"+em+"' where user_id='"+uid+"';";
												sm.executeUpdate(sql5);
												System.out.println("Record is updated");
											break;
										case 3:
											System.out.println("\nEnter the User ID for Verification: ");
											 uid=s.nextInt();
												
												System.out.println("\nEnter Phone Number to be updated: ");
												int phn=s.nextInt();
												String sql3 = "update users set user_phn='"+phn+"' where user_id='"+uid+"';";
												sm.executeUpdate(sql3);
												System.out.println("Record is updated");
											break;
										case 4: 
											System.out.println("\nEnter the User ID for Verification: ");
											uid=s.nextInt();
											
												System.out.println("\nEnter Location to be updated: ");
												String loc=s.next();
												
												String sql37 = "update users set user_loc='"+loc+"' where user_id='"+uid+"';";
												sm.executeUpdate(sql37);
												
												System.out.println("Record is updated");
											
											break;
											
										case 5: 
											System.out.println("\nEnter the User ID for Verification: ");
											 uid=s.nextInt();
												System.out.println("\nEnter Type to be updated: ");
												String ty=s.next();
												String sql38 = "update users set user_type='"+ty+"' where user_id='"+uid+"';";
												sm.executeUpdate(sql38);
												
												System.out.println("Record is updated");
											
											break;
										
										case 6: 
											System.out.println("\nEnter the User ID for Verification: ");
											 uid=s.nextInt();
												System.out.println("\nEnter Password to be updated: ");
												String pass=s.next();
												String sql39 = "update users set user_pass='"+pass+"' where user_id='"+uid+"';";
												sm.executeUpdate(sql39);
												System.out.println("Record is updated");
											
											break;
										
										}
										break;
										}while(ch5<7);
									}
						        	
						        }while(ch<5);	
						        }
		
							}
							catch (SQLException sql) 
							{
								System.out.println(sql);
							}
						}
					}	
			}
		}while(cho<3);
		}
		catch(Exception e)
		{  
			e.printStackTrace();
		} 
	}
}
