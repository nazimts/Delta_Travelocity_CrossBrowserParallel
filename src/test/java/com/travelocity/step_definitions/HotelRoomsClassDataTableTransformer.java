package com.travelocity.step_definitions;

import java.util.Locale;
import java.util.Map;

import com.travelocity.beans.HotelRooms;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;

public class HotelRoomsClassDataTableTransformer implements TypeRegistryConfigurer {
    
    public Locale locale() {
        return Locale.ENGLISH;
    }
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(HotelRooms.class,
                       new TableEntryTransformer<HotelRooms>() {
                    
            @Override
            
            public HotelRooms transform(Map<String, String> row) throws Throwable{
            	         
            	String description = row.get("Description");
        		String price = row.get("Price");
        		String numberOfGuests = row.get("Guests");
        		String square = row.get("Square");
        		String bed = row.get("Bed");
        		
                return new HotelRooms(description, price, numberOfGuests, square, bed);
                        }
                    }));
    }
}