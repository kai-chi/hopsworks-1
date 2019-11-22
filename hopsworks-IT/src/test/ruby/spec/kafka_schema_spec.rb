=begin
 This file is part of Hopsworks
 Copyright (C) 2019, Logical Clocks AB. All rights reserved

 Hopsworks is free software: you can redistribute it and/or modify it under the terms of
 the GNU Affero General Public License as published by the Free Software Foundation,
 either version 3 of the License, or (at your option) any later version.

 Hopsworks is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 PURPOSE.  See the GNU Affero General Public License for more details.

 You should have received a copy of the GNU Affero General Public License along with this program.
 If not, see <https://www.gnu.org/licenses/>.
=end

require 'json'

describe "On #{ENV['OS']}" do
  describe 'schemas' do
    context 'with valid project, test subject' do
      before :all do
        with_valid_project
        with_test_subject
      end

      after :all do
        clean_projects
      end

      describe 'basic operations on subjects' do
        it 'adds a new subject' do
          project = get_project
          register_new_schema(project, "test", "[]")
          expect_status(200)
	end
        
        it 'returns schema by its id' do
          get_schema_by_id(@project, @schemas[:id])
          expect_status(200)
          expect("[]").to eq(json_body[:schema])
        end
      end
    end
  end
end
