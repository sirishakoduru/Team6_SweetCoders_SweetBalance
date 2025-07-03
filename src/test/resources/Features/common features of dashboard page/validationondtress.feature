@stress

Feature: Validation on Stress Management technique Section for Registered Free user dashboard page
Background:  User is in Home Page after logged in 
@t15
  Scenario: Verify the header Stress Management Techniques
  When  User scrolls  to the Stress Management section
  Then  User should see the Title  "Stress Management Techniques"
  @t16
  Scenario: Verify the navigation bar order 
  Then  User should see tabs "Meditation", "Breathing", "Movement" and "Mindfulness"
  @t17
  Scenario: Verify tab navigation
  When User clicks on each tab
  Then User should see corresponding display section
  @t18
  Scenario: Verify Guided Meditation section is visible
  When  User clicks Meditation tab
  Then  User should see the content with title "Guided Meditation"
  @t19
  Scenario:  Verify meditation duration options are displayed
  Then  User should see buttons for "5 min", "10 min", and "15 min"
  @t20
  Scenario:  Verify audio player progress bar and time indicators
  Then  User should see a progress bar with time indicators "0:00" and "5:00" by default
  @t21
  Scenario: Verify audio playback functionality
  When User clicks audio play button
  Then  User Should see meditation audio should start playing and the progress bar should update accordingly
  @t22
  Scenario:Verify the Title displayed under Movement tab
  When  User clicks Movement Tab
  Then  User should see title "Gentle Movement" 
  @t23
  Scenario: Verify the content displayed under Movement tab
  Then  User should see the description "Simple stretches to release tension:" with the bullet points "Neck rolls - 5 times each direction","Shoulder circles - 10 times","Wrist and ankle rotations","Gentle torso twists"
  @t24
  Scenario: Verify the title under Mindfulness tab
  When User clicks Mindfulness tab
  Then  User should see title "Present Moment Awareness"
  @t25
  Scenario: Verify the content displayed under Mindfulness tab
  Then User should see the description "Focus on your senses:"with the bullet points "Notice 5 things you can see",
  @t26
  Scenario: Verify "Benefits for Diabetes Management" section is visible
  When User scroll to the end
  Then User should see the list of benefits "Reduces Stress Hormones" with explanation "Lowers cortisol that can increase blood glucose",
  @t27
  Scenario: Verify heading and description is displayed under Breathing tab
  When  User clicks breathing tab under stress management techniques
  Then User should see the heading "4-7-8 Breathing Technique"  with the description "A natural tranquilizer for the nervous system"
  @t28 
  Scenario: Verify Start button is displayed under Breathing tab
  Then  User should see the "Start Breathing Exercise" button
  @t29
  Scenario:Verify Cycle completed counter is displayed
  Then  User should see the "Cycles completed" counter text and value starting at 0
  @t30
  Scenario:Verify current phase counter is displayed
  Then  User should see the label 'Current phase' with a hyphen (-) as its current value.
  @t31
  Scenario:  verify breathing steps are displayed
  Then  User should see the steps "Inhale 4 seconds", "Hold 7 seconds", "Exhale 8 seconds"
  ////4
  @t32
  Scenario: Verify start button functionality
  When User clicks the "Start Breathing Exercise" button during the breathing exercise
  Then User should see the breathing cycles begin 
  @t33
  Scenario: Verify the inhale phase in breathing cycle
  Given  User started Breathing cycle
  When  User view the current phase begins
  Then  User should see the breathing cycle displays "Inhale" which last for 4 seconds
    
  #Scenario: Verify the hold phase in breathing cycle
  #Given User see the inhale phase is completed
  #When User view the next phase begins
  #Then  User should see the breathing cycle displays " hold" which last for 7 seconds
    
   #Scenario: Verify the Exhale phase in breathing cycle
  # Given  User see the hold phase has completed
   #When  User view the next phase begins
   #Then User should see the breathing cycle displays "Exhale" which last for 8 seconds
    @t34
   Scenario: Verify the count of cycle completed
   Given  User completed one full cycle
   When  User completes full breathing cycle
   Then  User should see "Cycles completed" counter should increased by 1
   @t35
   Scenario: Verify the pause phase in breathing cycle
   When User see next phase begins
   Then  User should see breathing cycle displays "pause" which last for 4 seconds
   @t36 
   Scenario: Verify stop button of breathing exercise
   #When User clicks the Stop button during the breathing exercise
   Then User should see breathing exercise stops
    
  
  
  
  
  
  