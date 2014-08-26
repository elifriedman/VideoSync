VideoSync
=========

Synchronizes the playing of video or audio on multiple computers so that people can watch in the same room and get the volume increase without annoying delays or offsets.

VideoSync allows you to watch the same video on different computers in close proximity. It's a handy way to increase the volume or to watch a video with a lot of people who don't want to be squished around one screen. The key to VideoSync is that all the computers listen to the master for time updates. When a computer realizes it's not synhronized with the master, it changes its playback rate to catch up to the master in a natural sounding way.

## To run:
- Download the VideoSync folder
- Navigate to the folder and run make (note you need to have javac installed)
```
cd /path/to/VideoSync
make
```
- Adjust the settings in props/www-server.properties.
  * timeout: the amount of time to wait after receiving a connection before dropping the connection.
  * workers: the number of threads to handle incoming connections
  * log: the server log file
  * port: the port on which to listen.
- run the server using make:
```
make run
```
- designate one computer as the master. That computer should use a web browser (Chrome works the best) to navigate to http://IP_of_Server:port/HTML/master.html where port was specified in the property file.
- the other computers should connect to http://IP_of_Server:port/HTML/video.html
- both the master and slaves should choose a file.
- Enjoy!

