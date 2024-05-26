# Song-Identifier
This project contains Python and Java code for identifying songs using audio files.

## Python Code

### Description
The Python script `identify_song.py` uses the `ShazamAPI` to identify songs. It takes the path to an audio file as input and prints the song title and artist if identified.

### How to Use
1. Ensure you have Python installed on your system.
2. Install the `shazamio` library by running:
   ```sh
   pip install shazamio
3. Save the Python code to a file named `identify_song.py`.
4. Run the script and provide the path to the audio file when prompted:
   ```sh
   python identify_song.py

#### Example
If you run the script and provide the path to an audio file, it will output something like:
		
		Enter the path to the audio file: /path/to/audio/file.mp3
		Song identified: Song Title by Artist Name

## Java Code
### Description
The Java program `IdentifySong.java` uses the `Audd` API to identify songs. It takes the path to an audio file as a command-line argument and prints the song title and artist if identified.

### How to Use
1. Ensure you have Java installed on your system.
2. Download the `okhttp` library and add it to your project. You can download it from [OkHttp](https://square.github.io/okhttp/) Releases.
3. Replace YOUR_API_KEY in the code with your actual API key from [Audd.io](https://audd.io/).
4. Save the Java code to a file named `IdentifySong.java`.
5. Compile and run the Java program, passing the path to the audio file as an argument:
   ```sh
   javac -cp .:okhttp-4.9.3.jar IdentifySong.java
	java -cp .:okhttp-4.9.3.jar IdentifySong /path/to/audio/file.mp3

#### Example
If you run the program with the audio file path as an argument, it will output something like:
	
 	Song identified: Song Title by Artist Name

>[!NOTE]
>Feel free to modify the code to better fit your needs.


