package confdb.converter.python;

import java.util.Iterator;

import confdb.converter.ConverterEngine;
import confdb.converter.ISwitchProducerWriter;
import confdb.converter.ConverterException;
import confdb.data.Reference;
import confdb.data.Referencable;
import confdb.data.ModuleInstance;
import confdb.data.EDAliasInstance;
import confdb.data.SwitchProducer;

public class PythonSwitchProducerWriter implements ISwitchProducerWriter {
	public String toString(SwitchProducer switchProducer, ConverterEngine converterEngine, String object) {
	        String str = object + switchProducer.name() + " = CUDASwitchProducer(\n ";
		String indent = "   ";
	    
		if (switchProducer.entryCount() > 0) {

			Iterator<Reference> list = switchProducer.entryIterator();
			
			while (list.hasNext()){
			    Reference ref = list.next();
			    Referencable refObj = ref.parent();
			    System.out.println("trying refObj "+refObj.name());
			    String modStr = new String();
			    if(refObj instanceof ModuleInstance){
			
				try {
				    modStr=converterEngine.getModuleWriter().toString((ModuleInstance)refObj,indent);
				} catch (ConverterException e) {
				    System.out.println("error for refObj "+refObj.name()+" "+e.getMessage());
				    modStr=e.getMessage();
				}
			    }else if(refObj instanceof EDAliasInstance){
				try {
				    modStr=converterEngine.getEDAliasWriter().toString((EDAliasInstance)refObj,indent);
				} catch (ConverterException e) {
				    System.out.println("error for refObj "+refObj.name()+" "+e.getMessage());
				    modStr=e.getMessage();
				}
			    }	
			    modStr = modStr.replaceFirst(switchProducer.name()+"_","");
			    modStr = modStr.trim();
			    modStr += ",\n";
			    str += "  "+modStr;
			}
					       
		}
		str += " )\n";
		return str;
	}
}
