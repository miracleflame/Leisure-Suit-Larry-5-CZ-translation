;;; Sierra Script 1.0 - (do not remove this comment)
(script# 200)
(include sci.sh)
(use Main)
(use LLRoom)
(use Class_255_0)
(use RandCycle)
(use CueObj)
(use n958)
(use Sound)
(use Cycle)
(use InvI)
(use User)
(use PicView)
(use Obj)

(public
	rm200 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5 =  5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	[local16 17] = [0 1 117 120 0 2 148 98 0 3 195 115 0 4 199 124 -32768]
	local33
	[local34 3]
)
(instance rm200 of LLRoom
	(properties
		lookStr {Vždycky tì zajímalo, jaké by to bylo cestovat limuzínou.}
		picture 200
	)
	
	(method (init &tmp temp0)
		(if (!= gGNumber 205)
			(gLongSong number: 0 client: 0 stop:)
			(gLongSong2 number: 0 client: 0 stop:)
		)
		(proc958_0 128 200 206)
		(proc0_3)
		(proc0_22 1)
		(User canControl: 0)
		(switch gGNumber
			(500 (proc0_7 9))
			(600 (= global161 1))
			(690
				(= global161 1)
				(proc0_7 29)
			)
			(700 (proc0_7 10))
			(800 (= global161 2))
			(890
				(= global161 2)
				(proc0_7 28)
			)
			(900 (proc0_7 11))
		)
		(if global179
			(proc958_0 128 204 201)
			(gLarry
				init:
				view: 201
				posn: 67 88 -100
				setPri: 14
				setCycle: 0
				setLoop: 0
				cycleSpeed: 6
				setCel: 0
				show:
				forceUpd:
			)
			(if (!= gGNumber 205) (proc0_2) (proc0_17 2 2 global2))
			(driver init: view: 204 setLoop: 2 stopUpd:)
			(driverBody init: view: 204 setCel: 1 setLoop: 0)
			(driverEyes init: view: 204)
			(if (!= gGNumber 250)
				(gIconBar disable: 0)
			else
				(= local15 1)
			)
			(driversWindow init: description: {Bobbi})
			(tv init: hide:)
		else
			(proc958_0 128 203 202)
			(if (proc999_5 gGNumber 800 600 425)
				(gIconBar enable: 0)
				(= local15 1)
			else
				(gIconBar disable: 0)
			)
			(driver init: view: 203 setLoop: 2)
			(driverBody init: view: 203 setCel: 1 setLoop: 0)
			(driverEyes init: view: 203)
			(gLarry
				init:
				view: 202
				setLoop: 6
				posn: 65 88 -100
				setPri: 14
				setCel: 0
				setCycle: 0
				ignoreActors: 1
				show:
				cycleSpeed: 6
				forceUpd:
			)
			(legs init: setScript: sLegs)
			(if (not (proc0_6 30)) (bottle init: stopUpd:))
			(if (and (proc0_6 28) (proc0_6 29))
				(proc0_17 20 1 global2)
				(proc0_2)
				(= global157 3)
			)
			(driversWindow init: description: {Bobby})
		)
		(phone init: stopUpd:)
		(glass init: stopUpd:)
		(theTv init:)
		(rightDoor init:)
		(stereo init:)
		(bottles_Glasses init:)
		(fishTank init:)
		(tapes init:)
		(vcr init:)
		(faxMachine init:)
		(fish
			init:
			setCycle: Fwd
			posn: (Random 241 304) (Random 87 106)
			setScript: sFishScript
		)
		(if
			(and
				(== global160 1)
				(not (proc0_6 31))
				(== gGNumber 250)
			)
			(dayTrotter init:)
		)
		(Load rsPIC 1)
		(Load rsSCRIPT 941)
		(super init:)
		(switch gGNumber
			(205
				(proc0_2)
				(= local7 1)
				(global2 drawPic: 200 11 setScript: sDrive)
			)
			(890 (global2 drawPic: 200 7))
			(else  (global2 drawPic: 200))
		)
	)
	
	(method (doit)
		(super doit:)
		(if local8 (Palette 6 56 63 2))
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if
				(and (== ((gIconBar at: 0) cursor?) 6) (not local7))
					(global2 newRoom: gGNumber)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (cue)
		(if global179
			(switch (++ local0)
				(1
					(if (proc999_5 gGNumber 190 250)
						(proc0_17 2 1 self)
					else
						(proc0_18 gLarry 200 0 108 self)
					)
				)
				(2
					(if (not (not (proc999_5 gGNumber 205 250)))
						(= local0 0)
						(proc0_3)
						(User canControl: 0)
					else
						(proc0_17 2 1 self)
					)
				)
				(3
					(proc0_7 8)
					(driver doVerb: 4 7)
				)
			)
		else
			(proc0_2)
			(proc0_18 gLarry 200 1)
			(= global176 425)
			(global2 setScript: sDream)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 205)
			(gLongSong fade: 0 15 10 1)
		else
			(gLongSong stop:)
			(= global176 0)
		)
		(gLongSong2 stop:)
		(tvSnd stop: dispose:)
		(proc0_22 0)
		(gLl5Timer dispose: delete:)
		(super newRoom: newRoomNumber)
	)
	
	(method (notify param1)
		(= local9 0)
		(switch param1
			(2779 (= local9 1))
			(-1 (proc0_14 200 2))
			(else  (proc0_14 200 3))
		)
	)
)

(instance sFishScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(if (< global172 3)
					(fish setLoop: 1)
				else
					(fish setLoop: 3)
				)
				(if (not global179)
					(self changeState: 10)
				else
					(= cycles 1)
				)
			)
			(1
				(= start state)
				(= cycles 1)
			)
			(2
				(if (< (fish x?) 262)
					(if (< global172 3)
						(fish setLoop: 1)
					else
						(fish setLoop: 3)
					)
					(fish
						setMotion: MoveTo (Random 270 304) (Random 87 106) self
					)
				else
					(if (< global172 3)
						(fish setLoop: 0)
					else
						(fish setLoop: 2)
					)
					(fish
						setMotion: MoveTo (Random 241 250) (Random 87 106) self
					)
				)
			)
			(3 (= seconds 2))
			(4 (self init:))
			(10
				(= start state)
				(= cycles 1)
			)
			(11
				(if (< (fish x?) 262)
					(= register 1)
					(fish
						setLoop: 1
						setMotion: MoveTo (Random 270 304) (Random 87 106) self
					)
				else
					(= register 0)
					(fish
						setLoop: 0
						setMotion: MoveTo (Random 241 250) (Random 87 106) self
					)
				)
			)
			(12
				(if (not (Random 0 2))
					(if register (fish setLoop: 3) else (fish setLoop: 2))
					(= seconds (Random 1 3))
				else
					(= seconds 1)
				)
			)
			(13 (self init:))
		)
	)
)

(instance fish of Actor
	(properties
		x 245
		y 100
		description {ryba}
		sightAngle 40
		lookStr {V akváriu limuzíny je zlatá rybka, které je špatnì.}
		view 206
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 200 4))
			(5 (proc0_14 200 5))
			(10 (proc0_14 200 6))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance glass of Actor
	(properties
		x 156
		y 38
		description {okno v soukromí}
		sightAngle 40
		lookStr {Kus zvukotìsného skla blokuje konverzaci mezi vámi a øidièem.}
		yStep 4
		view 200
		cel 3
		priority 3
		signal $6810
		illegalBits $0000
		xStep 4
	)
	
	(method (cue)
		(super cue:)
		(if (not local4) (= local4 1) else (= local4 0))
		(self stopUpd:)
		(proc0_3)
		(User canControl: 0)
		(if
			(or
				local7
				(not local15)
				(not (== ((gIconBar at: 0) cursor?) 6))
			)
			(gIconBar disable: 0)
		)
	)
)

(instance dayTrotter of View
	(properties
		x 8
		y 187
		description {Denní vùz\05}
		view 200
		cel 1
		priority 4
		signal $5810
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_14 200 7)
				(= local11 1)
			)
			(3
				(proc0_2)
				(arm
					init:
					view: 201
					setLoop: 2
					setCel: 0
					posn: 67 164
					setCycle: CT 2 1 arm
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance legs of Prop
	(properties
		x 73
		y 181
		description {tvoje noha}
		lookStr {Vždycky jsi mìl pocit, že tvé nohy jsou jednou z tvých lepších pøedností.}
		view 202
		loop 3
		priority 13
		signal $4810
	)
)

(instance theTv of Feature
	(properties
		x 161
		y 91
		nsTop 64
		nsLeft 117
		nsBottom 118
		nsRight 205
		description {televizor}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(if local3
					(proc0_14 200 8)
				else
					(proc0_14 200 9)
					(proc0_14 200 10 67 -1 185)
				)
			)
			(3
				(if global179
					(tvSnd number: 201 loop: 1 play:)
					(if local3
						(= local3 0)
						(tv hide:)
						(proc0_14 200 11)
					else
						(= local3 1)
						(tv show:)
						(proc0_14 200 12)
					)
				else
					(proc0_14 200 13)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance tv of Prop
	(properties
		x 162
		y 110
		nsTop 63
		nsLeft 116
		nsBottom 118
		nsRight 206
		description {televizor}
		sightAngle 40
		view 205
		priority 7
	)
	
	(method (doit)
		(super doit:)
		(if local3 (tv setCel: (Random 0 3)))
	)
	
	(method (doVerb)
		(theTv doVerb: &rest)
	)
)

(instance phone of Prop
	(properties
		x 161
		y 271
		z 100
		nsTop 162
		nsLeft 143
		nsBottom 174
		nsRight 186
		description {telefon}
		sightAngle 40
		view 200
		loop 1
		priority 10
		signal $4810
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 200 14))
			(3 (self setScript: sPhone))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance dreamProp1 of Prop
	(properties
		view 231
		priority 14
		signal $4010
	)
)

(instance dreamProp2 of Prop
	(properties
		view 231
		priority 14
		signal $4010
	)
)

(instance dreamProp3 of Prop
	(properties
		view 231
		priority 14
		signal $4010
	)
)

(instance arm of Prop
	(properties
		view 201
		priority 14
		signal $4010
	)
	
	(method (cue)
		(super cue:)
		(switch (++ local14)
			(1
				(if (not local1) (proc0_10 12))
				(gLarry get: 11)
				(proc0_7 31)
				(dayTrotter dispose:)
				(proc0_17 2 1 self)
			)
			(2 (self setCycle: Beg self))
			(3
				(= local14 0)
				(if (not local11) (proc0_14 200 7))
				(proc0_14 200 15)
				(if (not local1)
					(proc0_3)
					(User canControl: 0)
					(if
						(or
							local7
							(not local15)
							(not (== ((gIconBar at: 0) cursor?) 6))
						)
						(gIconBar disable: 0)
						(self dispose:)
					)
				else
					(global2 newRoom: global176)
				)
			)
		)
	)
)

(instance bottle of View
	(properties
		x 41
		y 111
		description {láhev šampaòského}
		sightAngle 40
		view 200
		priority 5
		signal $0810
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 200 16))
			(3
				(proc0_2)
				(proc0_7 30)
				(gLarry setScript: sGetBottle)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance faxPaper of Actor
	(properties
		x 55
		y 225
		z 100
		description {fax}
		yStep 1
		view 200
		cel 2
		priority 6
		signal $5810
		xStep 1
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(if (== (User canInput:) 1) (proc0_2))
				(gLarry
					view: 202
					setLoop: 1
					setCel: 0
					setCycle: CT 6 1 self
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (cue)
		(super cue:)
		(switch (++ local12)
			(1
				(proc0_2)
				(self hide:)
				(gLarry setCycle: End self)
			)
			(2
				(gLarry setLoop: 6)
				(proc0_17 2 1 self)
			)
			(3
				(switch local10
					(1
						(proc0_10 13 103)
						(proc0_14 200 17)
						(gLarry get: 3)
					)
					(2
						(proc0_10 13 104)
						(proc0_14 200 18)
						(gLarry get: 7)
					)
				)
				(= local12 0)
				(= local10 0)
				(proc0_3)
				(User canControl: 0)
				(if
					(or
						local7
						(not local15)
						(not (== ((gIconBar at: 0) cursor?) 6))
					)
					(gIconBar disable: 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance vcr of Feature
	(properties
		x 162
		y 152
		z 100
		nsTop 45
		nsLeft 114
		nsBottom 60
		nsRight 211
		description {videorekordér}
		sightAngle 40
		lookStr {Nad televizorem leží profesionální pøehrávaè videokazet.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 200 19))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance tapes of Feature
	(properties
		x 245
		y 257
		z 200
		nsTop 45
		nsLeft 211
		nsBottom 70
		nsRight 279
		description {videokazety}
		sightAngle 40
		lookStr {V tom stojanu je spousta videokazet, které bys rád vidìl. Bohužel je videorekordér rozbitý!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 200 20))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance fishTank of Feature
	(properties
		x 266
		y 94
		nsTop 71
		nsLeft 217
		nsBottom 118
		nsRight 316
		description {akvárium}
		sightAngle 40
		lookStr {Jak bizarní! Limuzína s akváriem!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(if (not (Random 0 10))
					(proc0_14 200 21)
				else
					(proc0_14 200 4)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance dreamBubble of Prop
	(properties
		view 207
		priority 15
		signal $4810
	)
)

(instance bottles_Glasses of Feature
	(properties
		x 73
		y 178
		z 100
		nsTop 46
		nsLeft 31
		nsBottom 111
		nsRight 115
		description {lahve a sklenice}
		sightAngle 40
		onMeCheck $0004
		lookStr {Tady je dost lahví alkoholu a sklenièek na poøádání veèírku. Teï už potøebuješ jen pár pøátel!}
		name "bottles&Glasses"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(if (gCast contains: bottle)
					(bottle doVerb: 3)
				else
					(proc0_14 200 22)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance stereo of Feature
	(properties
		x 165
		y 248
		z 100
		nsTop 117
		nsLeft 110
		nsBottom 178
		nsRight 222
		description {stereo}
		sightAngle 40
		lookStr {V limuzínì je stereo s kazetovým pøehrávaèem i CD.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 200 23))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance rightDoor of Feature
	(properties
		x 286
		y 146
		nsTop 123
		nsLeft 253
		nsBottom 170
		nsRight 319
		description {dveøe skøínì}
		sightAngle 40
		onMeCheck $0002
		lookStr {Pod pravým pøedním sedadlem spolujezdce se nachází malá uzamèená pøihrádka na alkohol. Pøemýšlíš, kdy pøijde øada na tebe, abys mohl žít na vysoké noze.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 200 24))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance sRoll of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(dreamProp1 setLoop: (Random 0 1) setCycle: End self)
			)
			(1 (= cycles (Random 4 10)))
			(2
				(dreamProp1 setCycle: Beg self)
			)
			(3 (= cycles (Random 4 10)))
			(4 (self init:))
		)
	)
)

(instance sPhone of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(Load rsSOUND 36)
				(= local6 1)
				(if global179
					(gLarry cycleSpeed: 8 setCycle: CT 5 1 self)
					(= register 5)
				else
					(gLarry stopUpd:)
					(arm
						init:
						view: 202
						posn: 65 188
						setLoop: 0
						cycleSpeed: 8
						setCycle: CT 3 1 self
					)
					(legs setScript: 0 setCel: 0 stopUpd:)
				)
			)
			(1
				(phone hide:)
				(gLongSong2 number: 36 loop: 1 play:)
				(if global179
					(gLarry setCycle: End self)
				else
					(arm setCycle: End self)
				)
			)
			(2
				(cond 
					(global179
						(proc0_14 200 25 80 {Bobbi})
						(proc0_14 200 26 80 {Bobbi})
						(proc0_18 gLarry 200 27)
						(++ state)
						(= cycles 2)
					)
					((and (proc0_6 103) (proc0_6 104)) (User canInput: 1) ((ScriptID 20 0) init: 1 self))
					(local9 (proc0_14 200 28) (++ state) (= cycles 2))
					((not local10) (User canInput: 1) ((ScriptID 20 0) init: 1 self))
					(else (proc0_14 200 29) (++ state) (= cycles 2))
				)
			)
			(3
				(gIconBar curIcon: (gIconBar at: 2))
				(gGame setCursor: ((gIconBar curIcon?) cursor?))
				(if local9
					(proc0_14 200 30)
					(proc0_14 200 31 80 {Desmond})
					(cond 
						((and (proc0_6 103) (proc0_6 104))
							(proc0_18 gLarry 200 32)
							(proc0_14 200 33 80 {Desmond})
							(proc0_18 gLarry 200 34)
						)
						(
						(and (not (proc0_6 103)) (not (proc0_6 104)))
							(proc0_18 gLarry 200 35)
							(proc0_14 200 36 80 {Desmond})
							(= local10
								(proc255_0
									200
									37
									81
									{ReverzníBiaz}
									1
									81
									{PCHammer}
									2
									80
									{Ty}
								)
							)
						)
						((proc0_6 103)
							(proc0_18 gLarry 200 38)
							(proc0_14 200 39 80 {Desmond})
							(= local10 2)
						)
						((proc0_6 104)
							(proc0_18 gLarry 200 40)
							(proc0_14 200 39 80 {Desmond})
							(= local10 1)
						)
					)
					(if local10 (faxPaper init: hide: setScript: sFax))
				)
				(= ticks 50)
			)
			(4
				(if global179
					(gLarry setCycle: CT 5 -1 self)
				else
					(arm setCycle: CT 3 -1 self)
				)
			)
			(5
				(phone show:)
				(gLongSong2 number: 36 loop: 1 play:)
				(if global179
					(gLarry setCycle: Beg self)
				else
					(arm setCycle: Beg self)
				)
			)
			(6
				(if
					(or
						local7
						(not local15)
						(not (== ((gIconBar at: 0) cursor?) 6))
					)
					(gIconBar disable: 0)
				)
				(if (not global179)
					(legs startUpd: setScript: sLegs)
					(arm dispose:)
				)
				(= local6 0)
				(= cycles 2)
			)
			(7
				(proc0_3)
				(User canControl: 0)
				(if (not local15) (gIconBar disable: 0))
				(self dispose:)
			)
		)
	)
)

(instance driverEyes of Prop
	(properties
		x 155
		y 6
		description {zrcadlo}
		view 204
		loop 1
		priority 1
		signal $6810
	)
)

(instance sLegs of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 2))
			(1
				(legs setCycle: Fwd cycleSpeed: (Random 6 10))
				(= cycles (Random 20 40))
			)
			(2
				(legs setCel: 0 stopUpd:)
				(= cycles (Random 10 30))
			)
			(3 (self init:))
		)
	)
)

(instance windowL of Prop
	(properties
		x 17
		y 46
		description {okno}
		view 208
		priority 14
		signal $6810
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 200 41))
			(2
				(if local7 (proc0_14 200 42) else (proc0_14 200 43))
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance tvSnd of Sound
	(properties)
)

(instance faxMachine of Feature
	(properties
		x 59
		y 213
		z 100
		nsTop 101
		nsLeft 31
		nsBottom 125
		nsRight 87
		description {fax}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_14 200 44)
				(proc0_14 200 45 67 -1 185)
			)
			(3
				(if (and local10 (not local9))
					(proc0_2)
					(faxPaper doVerb: 3)
				else
					(proc0_14 200 46)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance sFax of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 4 6)))
			(1
				(proc0_2)
				(Load rsSOUND 203)
				(= cycles 2)
			)
			(2
				(gLongSong number: 203 loop: 1 play: self)
				(proc0_14 200 47)
			)
			(3
				(faxPaper
					show:
					ignoreActors: 1
					moveSpeed: 5
					posn: 55 225
					setMotion: MoveTo 55 215 self
				)
			)
			(4
				(= local9 0)
				(proc0_3)
				(User canControl: 0)
				(if
					(or
						local7
						(not local15)
						(not (== ((gIconBar at: 0) cursor?) 6))
					)
					(gIconBar disable: 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance driverBody of Prop
	(properties
		x 114
		y 34
		description {tvùj øidiè limuzíny}
		view 204
		priority 1
		signal $6810
	)
)

(instance driversWindow of Feature
	(properties
		x 160
		y 119
		z 100
		nsTop -1
		nsLeft 49
		nsBottom 42
		nsRight 269
		sightAngle 40
		lookStr {Jsi oddìlen od svého øidièe tím velkým zvukotìsným oknem.}
	)
	
	(method (doVerb)
		(driver doVerb: &rest)
	)
)

(instance sGetBottle of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					view: 202
					setLoop: 1
					setCel: 0
					cycleSpeed: 6
					setCycle: CT 3 1 self
				)
			)
			(1
				(gLarry setLoop: 2 setCel: 0)
				(= cycles 1)
			)
			(2
				(gLarry cycleSpeed: 6 setCycle: CT 3 1 self)
			)
			(3
				(bottle dispose:)
				(gLarry setCycle: End self)
			)
			(4
				(gLarry setLoop: 6 setCel: 0 posn: 65 88 get: 4)
				(if
					(or
						local7
						(not local15)
						(not (== ((gIconBar at: 0) cursor?) 6))
					)
					(gIconBar disable: 0)
				)
				(proc0_10 6)
				(= cycles 2)
			)
			(5
				(proc0_3)
				(User canControl: 0)
				(if (not local15) (gIconBar disable: 0))
				(self dispose:)
			)
		)
	)
)

(instance sDrive of Script
	(properties)
	
	(method (doit &tmp [temp0 10])
		(super doit:)
		(if (not (-- local5))
			(driverBody setCel: (Random 0 2))
			(= local5 (Random 5 10))
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local7 1)
				(if global179
					(proc0_3)
					(User canControl: 0)
					(gIconBar disable: 0)
				)
				(gLongSong number: 204 loop: -1 play: 127)
				(if (== gGNumber 205)
					(windowL init: cycleSpeed: 3 setCycle: Fwd)
					(= state 29)
					(= seconds 3)
				else
					(windowL init: cycleSpeed: 6 setCycle: Fwd)
					(= seconds 5)
				)
			)
			(1
				(windowL cycleSpeed: 3)
				(= seconds 5)
			)
			(2
				(windowL cycleSpeed: 0)
				(if global179 (= seconds 4) else (= seconds 12))
			)
			(3
				(= start state)
				(= cycles 2)
			)
			(4
				(cond 
					(local6 (self init:))
					((and (not global179) (not local33)) (self init:))
					(
					(and global179 (not (proc999_5 gGNumber 205 250))) (global2 newRoom: 205))
					(else (= seconds 3))
				)
			)
			(5
				(windowL cycleSpeed: 3)
				(= seconds 3)
			)
			(6
				(= start state)
				(= cycles 1)
			)
			(7
				(if local6
					(self init:)
				else
					(proc0_2)
					(driver setCycle: End)
					(driverEyes setCycle: End)
					(= state 29)
					(= cycles 2)
				)
			)
			(30
				(if gTheNewDialog (gTheNewDialog dispose:))
				(gLongSong fade: 0 15 10 0)
				(if global179
					(proc0_14 200 48 80 {Bobbi})
					(= cycles 2)
				else
					(++ state)
					(gLongSong2 fade: 0 15 10 1)
					(= seconds 2)
				)
			)
			(31
				(proc0_8 1)
				(if (!= global176 250) (proc0_8 38))
				(if (and (== global176 900) (gLarry has: 10))
					(proc0_18 gLarry 200 49)
					(gLarry put: 10)
					(= global168 0)
				)
				(if
				(and (== global176 500) (not (gLarry has: 11)))
					(proc0_14 200 50)
					(= local1 1)
					(dayTrotter doVerb: 3 &rest)
				else
					(if (and (proc0_6 9) (gLarry has: 11))
						(gLarry put: 11 put: 13 put: 12)
						(proc0_14 200 51)
					)
					(global2 newRoom: global176)
				)
			)
			(32
				(if gTheNewDialog (gTheNewDialog dispose:))
				(gCast eachElementDo: #hide)
				(global2 drawPic: 1 10)
				(proc0_25 2 global128 200 52)
				(= seconds 3)
			)
			(33
				(switch global176
					(425 0)
					(800 (= global161 2))
					(600 (= global161 1))
				)
				(global2 newRoom: 320)
			)
		)
	)
)

(instance driver of Prop
	(properties
		x 114
		y 34
		description {tvùj øidiè limuzíny}
		view 204
		priority 2
		signal $6810
	)
	
	(method (doVerb theVerb param2 &tmp [temp0 80])
		(switch theVerb
			(2
				(if global179
					(switch global160
						(0 (proc0_14 200 59))
						(1 (proc0_14 200 60))
						(2 (proc0_14 200 61))
						(3 (proc0_14 200 62))
					)
				else
					(proc0_14 200 63)
				)
			)
			(3
				(cond 
					(local7 (proc0_14 200 64))
					(global179 (proc0_14 200 65))
					(else
						(proc0_2)
						(gLongSong number: 202 loop: 1 play:)
						(if (not local4)
							(glass setMotion: MoveTo (glass x?) 78 glass)
						else
							(glass setMotion: MoveTo (glass x?) 38 glass)
						)
					)
				)
			)
			(5
				(cond 
					(local7
						(Format
							@temp0
							200
							66
							(if global179 {Sh} else {H})
							(if global179 {sh} else {h})
						)
						(proc0_14 @temp0)
					)
					(global179
						(switch (Random 1 2)
							(1 (proc0_14 200 67))
							(2 (proc0_14 200 68))
						)
						(proc0_14 200 69)
					)
					(local4 (proc0_14 200 70 80 {Bobby}))
					(else (proc0_14 200 71))
				)
			)
			(10
				(cond 
					(global179
						(proc0_18 gLarry 200 72)
						(proc0_14 200 73)
						(proc0_14 200 74 67 -1 185)
					)
					((proc0_6 29) (proc0_14 200 75 80 {Bobby}))
					(local7 (proc0_14 200 76 80 {Bobby}))
					(else (proc0_14 200 77 80 {Bobby}))
				)
			)
			(4
				(if global179
					(if global176
						(proc0_14 200 78 80 {Bobbi})
					else
						(switch param2
							(7
								(if (== gGNumber 250)
									(proc0_14 200 79 80 {Bobbi})
								else
									(arm
										init:
										view: 201
										setLoop: 1
										posn: 96 163
										setCel: 0
										cycleSpeed: 8
										setCycle: End self
									)
									(= global176 250)
								)
							)
							(6
								(cond 
									((!= global160 1) (proc0_14 200 80 80 {Bobbi}))
									((not (proc999_5 gGNumber 205 250)) (proc0_14 200 81 80 {Bobbi}))
									((proc0_6 9) (proc0_14 200 82 80 {Bobbi}))
									(else
										(arm
											init:
											view: 201
											setLoop: 1
											posn: 96 163
											setCel: 0
											setCycle: End self
										)
										(= global176 500)
									)
								)
							)
							(16
								(cond 
									((!= global160 2) (proc0_14 200 83 80 {Bobbi}))
									((not (proc999_5 gGNumber 205 250)) (proc0_14 200 81 80 {Bobbi}))
									((proc0_6 10) (proc0_14 200 84))
									(else
										(arm
											init:
											view: 201
											setLoop: 1
											posn: 96 163
											setCel: 0
											setCycle: End self
										)
										(= global176 700)
									)
								)
							)
							(20
								(cond 
									((!= global160 3) (proc0_14 200 85 80 {Bobbi}))
									((not (proc999_5 gGNumber 205 250)) (proc0_14 200 81 80 {Bobbi}))
									((proc0_6 11) (proc0_14 200 86))
									(else
										(arm
											init:
											view: 201
											setLoop: 1
											posn: 96 163
											setCel: 0
											setCycle: End self
										)
										(= global176 900)
									)
								)
							)
							(else 
								(super doVerb: theVerb param2 &rest)
							)
						)
					)
				else
					(switch param2
						(3
							(cond 
								((== global161 1) (proc0_14 200 87 80 {Bobby}))
								((proc0_6 29) (proc0_14 200 88 80 {Bobby}))
								(global176 (proc0_14 200 89 80 {Bobby}))
								(else
									(proc0_10 8 95)
									(arm
										view: 202
										init:
										setLoop: 4
										setCel: 0
										posn: 98 182
										setCycle: End self
									)
									(= global157 (+ global157 1))
									(= global176 600)
									(= local9 0)
									(faxPaper setScript: 0)
								)
							)
						)
						(7
							(cond 
								((== global161 2) (proc0_14 200 87 80 {Bobby}))
								((proc0_6 28) (proc0_14 200 88 80 {Bobby}))
								(global176 (proc0_14 200 89 80 {Bobby}))
								(else
									(proc0_10 8 95)
									(arm
										view: 202
										init:
										setLoop: 4
										setCel: 0
										posn: 98 182
										setCycle: End self
									)
									(= global157 (+ global157 2))
									(= global176 800)
									(= local9 0)
									(faxPaper setScript: 0)
								)
							)
						)
						(0
							(switch ((Inv at: 0) state?)
								(0 (proc0_14 200 90))
								(1
									(cond 
										((== global161 1) (proc0_14 200 87 80 {Bobby}))
										((proc0_6 29) (proc0_14 200 88 80 {Bobby}))
										(global176 (proc0_14 200 89 80 {Bobby}))
										(else
											(proc0_10 8 95)
											(arm
												view: 202
												init:
												setLoop: 5
												setCel: 0
												posn: 96 184
												setCycle: End self
											)
											(= global157 (+ global157 1))
											(= global176 600)
											(= local9 0)
											(faxPaper setScript: 0)
										)
									)
								)
								(2
									(cond 
										((== global161 2) (proc0_14 200 87 80 {Bobby}))
										((proc0_6 28) (proc0_14 200 88 80 {Bobby}))
										(global176 (proc0_14 200 89 80 {Bobby}))
										(else
											(proc0_10 8 95)
											(arm
												view: 202
												init:
												setLoop: 5
												setCel: 0
												posn: 96 184
												setCycle: End self
											)
											(= global157 (+ global157 2))
											(= global176 800)
											(= local9 0)
											(faxPaper setScript: 0)
										)
									)
								)
							)
						)
						(else 
							(super doVerb: theVerb param2 &rest)
						)
					)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (cue)
		(super cue:)
		(switch (++ local13)
			(1
				(proc0_2)
				(driver setCycle: End)
				(driverEyes setCycle: End)
				(proc0_17 2 0 self)
			)
			(2
				(switch global176
					(250
						(proc0_14 200 53 80 {Bobbi})
						(proc0_17 2 1 self)
					)
					(500
						(proc0_14 200 54 80 {Bobbi})
						(proc0_17 2 1 self)
					)
					(700
						(proc0_14 200 55 80 {Bobbi})
						(proc0_17 2 1 self)
					)
					(900
						(proc0_14 200 56 80 {Bobbi})
						(proc0_17 2 1 self)
					)
					(600
						(proc0_14 200 57 80 {Bobby})
						(if (== gGNumber 800) (proc0_7 28))
						(proc0_17 2 1 self)
					)
					(800
						(proc0_14 200 58 80 {Bobby})
						(if (== gGNumber 600) (proc0_7 29))
						(proc0_17 2 1 self)
					)
				)
			)
			(3
				(driver setCycle: Beg)
				(driverEyes setCycle: Beg)
				(arm setCycle: Beg self)
			)
			(4
				(= local13 0)
				(arm dispose:)
				(if global179
					(global2 setScript: sDrive)
				else
					(global2 setScript: sDream)
				)
			)
		)
	)
)

(instance sDream of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(driver setScript: sDrive)
				(legs setScript: 0 setCel: 0)
				(= seconds 8)
			)
			(1
				(= local8 1)
				(gLongSong fade: 0 15 5 0)
				(gLongSong2 stop:)
				(= seconds 2)
			)
			(2
				(gLongSong2
					number: 320
					loop: -1
					play: 0
					fade: 127 15 10 0
				)
				(proc0_14 200 91 67 -1 185 108)
				(tv dispose:)
				(fish setScript: 0 stopUpd:)
				(dreamBubble init: setLoop: 0 setCel: 1 posn: 117 120)
				(= ticks 90)
			)
			(3
				(dreamBubble setCel: 2 posn: 148 98)
				(= ticks 90)
			)
			(4
				(dreamBubble setCel: 3 posn: 195 115)
				(= ticks 90)
			)
			(5
				(dreamBubble setCel: 4 posn: 199 124)
				(= ticks 90)
			)
			(6
				(if gTheNewDialog (gTheNewDialog dispose:))
				(dreamBubble dispose:)
				(fish hide:)
				(bottle hide:)
				(tv hide:)
				(switch (++ global162)
					(1
						(global2 overlay: 230)
						(dreamProp1
							init:
							view: 231
							setLoop: 0
							posn: 205 90
							setScript: sRoll
						)
					)
					(2
						(global2 overlay: 235)
						(dreamProp1
							init:
							view: 235
							posn: 123 69
							cycleSpeed: 6
							setCycle: RandCycle
						)
						(dreamProp2
							init:
							view: 236
							posn: 231 87
							cycleSpeed: 8
							setCycle: RandCycle
						)
					)
					(3
						(global2 overlay: 240)
						(gLongSong2 number: 241 play:)
						(dreamProp1
							init:
							view: 240
							setLoop: 0
							setCel: 0
							cycleSpeed: 8
							setCycle: Fwd
							posn: 258 93
							setPri: 13
						)
						(dreamProp2
							init:
							view: 241
							setLoop: 0
							posn: 260 106
							setPri: 12
							cycleSpeed: 10
							setCycle: RandCycle
						)
						(dreamProp3
							init:
							view: 241
							setLoop: 1
							setCel: 0
							cycleSpeed: 5
							setCycle: End
							posn: 203 31
							setPri: 14
						)
					)
				)
				(= seconds 3)
			)
			(7
				(switch global162
					(1
						(proc0_18 gLarry 200 92)
						(proc0_14 200 93 80 {Donald})
						(proc0_18 gLarry 200 94)
						(proc0_14 200 95 80 {The Donald})
					)
					(2
						(proc0_18 gLarry 200 96)
						(proc0_14 200 97 80 {Willie})
					)
					(3
						(proc0_18 gLarry 200 98)
						(proc0_14 200 99 80 {Sir Francis})
					)
				)
				(= local33 1)
			)
		)
	)
)
