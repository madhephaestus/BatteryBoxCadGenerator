import eu.mihosoft.vrl.v3d.parametrics.*;
import java.util.stream.Collectors;
import com.neuronrobotics.bowlerstudio.vitamins.Vitamins;
import eu.mihosoft.vrl.v3d.CSG;
import eu.mihosoft.vrl.v3d.Cube;
CSG generate(){
	String type= "BatteryBox"
	if(args==null)
		args=["9vbattery"]
	// The variable that stores the current size of this vitamin
	StringParameter size = new StringParameter(	type+" Default",args.get(0),Vitamins.listVitaminSizes(type))
	HashMap<String,Object> measurments = Vitamins.getConfiguration( type,size.getStrValue())

	def heightValue = measurments.height
	def lengthValue = measurments.length
	def massCentroidXValue = measurments.massCentroidX
	def massCentroidYValue = measurments.massCentroidY
	def massCentroidZValue = measurments.massCentroidZ
	def massKgValue = measurments.massKg
	def priceValue = measurments.price
	def sourceValue = measurments.source
	def widthValue = measurments.width
	for(String key:measurments.keySet().stream().sorted().collect(Collectors.toList())){
		println "BatteryBox value "+key+" "+measurments.get(key);
}
	// Stub of a CAD object
	CSG part = new Cube().toCSG()
	return part
		.setParameter(size)
		.setRegenerate({generate()})
}
return generate() 