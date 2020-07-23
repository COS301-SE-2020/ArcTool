package com.company;

public class FunctionalRequirements {
    /**
     * The is the class constructor
     */

    public FunctionalRequirements()
    {

    }

    /**
     * These are the functional requirements
     */
    public void FRequirements()
    {
        System.out.println("FR:Mouthpiece shall synchronise input audio from the phones microphone to an animated mouth using volume based conversion.");
        System.out.println("FR:Mouthpiece  shall  synchronise  input  audio  from  the  phones  microphone  to  an  animated mouth using Formant based conversion through a neural network.");
        System.out.println("FR:Mouthpiece shall allow users to choose their own mouth shapes.");
        System.out.println("FR:Mouthpiece shall also allow a user to create their own mouth by selecting and customising different mouth shapes.");
        System.out.println("FR:Mouthpiece shall work in either offline or online mode.");
        System.out.println("FR:Mouthpiece shall synchronise and convert the audio input into an animated mouth in real-time.");
        System.out.println("FR:Mouthpiece  shall  allow  the  user  to  read  pre-determined  sentences  to  train  the  AI  neu-ral network if necessary.");
        System.out.println("FR:Mouthpiece shall allow a user to upload/backup their settings to an online/cloud backup.");
        System.out.println("FR:Mouthpiece shall allow a user to restore a users settings from an online/cloud backup.R1.7Mouthpiece  shall  allow  a  user  to  upload  their  custom  mouth  creations  to  the  online  com-panion site.");
        System.out.println("FR:Mouthpiece shall allow a user to download other mouth shapes from the companion website.R1.8Mouthpiece shall require access to the microphone.");
        System.out.println("FR:Cloud backup serverR2.1Cloud backup server should handle multiple users uploading and download requests efficiently.R2.2Cloud backup server should store username and password on the database.");
        System.out.println("FR:Cloud backup server should authenticate when a user initiates a connection request.R2.4Cloud backup server should allow a user to backup and restore their app settings.");
        System.out.println("FR:Cloud backup server should store a users AI training data if necessary.");

    }
}
