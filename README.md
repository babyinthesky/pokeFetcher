# pokeFetcher
Pokemon fetcher using Pokemon get api


javac -classpath "./json-20170516.jar"  src/pokeFetcher/*.java
java -classpath .:json-20170516.jar:src pokeFetcher.PokeFetcher start_id end_id  
/* start_id and end_id should be numbers
e.g. 
java -classpath .:json-20170516.jar:src pokeFetcher.PokeFetcher 20 70
*/
