require 'compass/import-once/activate'
require 'rubygems'
require 'ruby_gntp'
#require 'compass-growl'
# Require any additional compass plugins here.
# Set this to the root of your project when deployed:
http_path = "/"
css_dir = "css"
sass_dir = "sass"
fonts_dir = "fonts"
images_dir = "../images"
javascripts_dir = "../resources/js"
cache_path = 'C:/.sass-cache'
ICON = File.join(File.expand_path('../', __FILE__), '..', 'images', 'Logo.png')
ERRORICON = File.join(File.expand_path('../', __FILE__), '..', 'images', 'errorstop.png')
preferred_syntax = :scss
relative_assets = false
if environment == :development
    line_comments = true
    output_style = :expanded
    
    on_stylesheet_saved do |filename|
		growl = GNTP.new("Tolja's custom growl")
		growl.register({:notifications => [{
		  :name     => "notify",
		  :enabled  => true,
		}]})
		
		growl.notify({
		  :name  => "notify",
		  :title => "Successful",
		  :text  => "#{File.basename(filename)} updated!",
		  :icon  => "file://#{ICON}"
		})
	end
	on_stylesheet_error do |filename, message|
		growl = GNTP.new("Tolja's custom growl")
		growl.register({:notifications => [{
		  :name     => "notify",
		  :enabled  => true,
		}]}) 
		
		growl.notify({
		  :name  => "notify",
		  :title => "Error",
		  :text  => "#{File.basename(filename)}: #{message}",
		  :icon  => "file://#{ERRORICON}"
		})
	end
end

if environment == :production
    line_comments = false
    output_style = :compressed
end  
 
 # Growl.notify {
 #   self.message = "#{File.basename(file)}: 'aaaaaa'"
 #   self.icon = '../images/pixel.png'
 #   sticky!
#  }
# cache_path is important to be as short as it can, if cache_path is to long it won't compile. NOTE:this is problem only on windows.
# cache_path = 'desired_path/.sass-cache

# You can select your preferred output style here (can be overridden via the command line):
# output_style = :expanded or :nested or :compact or :compressed

# To enable relative paths to assets via compass helper functions. Uncomment:


# To disable debugging comments that display the original location of your selectors. Uncomment:
# line_comments = false


# If you prefer the indented syntax, you might want to regenerate this
# project again passing --syntax sass, or you can uncomment this:
# preferred_syntax = :sass
# and then run:
# sass-convert -R --from scss --to sass sass scss && rm -rf sass && mv scss sass

#moves file after compiling to parent directory
#require 'fileutils'
#on_stylesheet_saved do |file|
#  if File.exists?(file) && File.basename(file) == "style.css"
#    puts "Moving: #{file}"
#    FileUtils.mv(file, File.dirname(file) + "/../" + File.basename(file))
#  end
#end
